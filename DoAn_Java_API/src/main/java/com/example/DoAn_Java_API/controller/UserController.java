package com.example.DoAn_Java_API.controller;

import com.example.DoAn_Java_API.config.Security.HasRoleADMIN;
import com.example.DoAn_Java_API.jwt.JwtGeneratorInterface;
import com.example.DoAn_Java_API.jwt.UserNotFoundException;
import com.example.DoAn_Java_API.model.*;
import com.example.DoAn_Java_API.repository.IRoleRepository;
import com.example.DoAn_Java_API.repository.IUserRepository;
import com.example.DoAn_Java_API.services.CustomerService;
import com.example.DoAn_Java_API.services.MailService;
import com.example.DoAn_Java_API.services.UserService;
import com.nimbusds.oauth2.sdk.util.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins = "http://localhost:9998")
public class UserController {
    @Autowired
    private MailService mailService;
    @Autowired
    private CustomerService customerService;
    private UserService userService;
    private IRoleRepository roleRepository;
    private JwtGeneratorInterface jwtGenerator;
    private IUserRepository userRepository;



//    @Autowired
//    public UserController(UserService userService, JwtGeneratorInterface jwtGenerator) {
//        this.userService = userService;
//        this.jwtGenerator = jwtGenerator;
//    }

    @Autowired
    public UserController(IRoleRepository roleRepository, UserService userService, JwtGeneratorInterface jwtGenerator, IUserRepository userRepository) {
        this.userService = userService;
        this.jwtGenerator = jwtGenerator;
        this.userRepository = userRepository;
        this.roleRepository= roleRepository;
    }



    @PostMapping("/register")
    public ResponseEntity<?> postUser(@RequestBody User user) {
        try {
            // Kiểm tra sự tồn tại của tên đăng nhập trong cơ sở dữ liệu
            User existingUser = userService.getUserByUserName(user.getUsername());
            if (existingUser != null) {
                throw new Exception("Tên đăng nhập đã tồn tại");
            }
            existingUser = userService.getUserByEmail(user.getEmail());
            if (existingUser != null) {
                throw new Exception("Email đã tồn tại");
            }

            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword())); // Mã hóa mật khẩu trước khi lưu người dùng
            userService.saveUser(user);
            if(user.getKhachHang()==null){
                KhachHang k= new KhachHang();
                k.setEmail(user.getEmail());
                k.setHoten(user.getName());
                k.setUser(user);
                customerService.addCustomer(k);
            }


            // Trả về thông báo đăng ký thành công
            Map<String, String> response = new HashMap<>();
            response.put("message","Đăng ký thành công");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            // Trả về thông báo lỗi đăng ký
            Map<String, String> response = new HashMap<>();
            response.put("error", "Lỗi: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }
    @HasRoleADMIN
    @PutMapping("/updateRole")
    public ResponseEntity<?> edit(@RequestParam Long userId, @RequestParam Long idRole) {
        try {
            // Kiểm tra sự tồn tại của tên đăng nhập trong cơ sở dữ liệu
            User existingUser = userService.getByUserID(userId);
            if (existingUser == null) {
                throw new Exception("Không tồn tại");
            }
            Role role=roleRepository.findById(idRole).orElse(null);
            if (role == null) {
                throw new Exception("Không tồn tại");
            }
            existingUser.setRole(role);
            System.out.println(role.getRoleName());
            userService.updateUser(existingUser);
            System.out.println(existingUser.getUsername());
            System.out.println(existingUser.getRole().getRoleName());


            return new ResponseEntity<>(existingUser, HttpStatus.OK);
        } catch (Exception e) {
            // Trả về thông báo lỗi đăng ký
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            if (user.getUsername() == null || user.getPassword() == null) {
                throw new UserNotFoundException("Tên đăng nhập hoặc mật khẩu trống");
            }

            // Lấy người dùng từ cơ sở dữ liệu bằng tên đăng nhập
            User userData = userService.getUserByUserName(user.getUsername());
            if (userData == null) {
                throw new UserNotFoundException("Tên đăng nhập hoặc mật khẩu không đúng");
            }

            // So sánh mật khẩu đã mã hóa với mật khẩu người dùng cung cấp
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            boolean passwordMatch = passwordEncoder.matches(user.getPassword(), userData.getPassword());
            if (!passwordMatch) {
                throw new UserNotFoundException("Tên đăng nhập hoặc mật khẩu không đúng");
            }

            return new ResponseEntity<>(jwtGenerator.generateToken(userData), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Lỗi: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/getUserInfo")
    public ResponseEntity<?> getUserInfo(@RequestParam("token") String token) {
        try {
            // Giải mã token để lấy thông tin người dùng
            Map<String, Object> decodedToken = jwtGenerator.decodeToken(token);
            System.out.println("Decoded Token: " + decodedToken);
            String username = (String) decodedToken.get("username");
            // Lấy các thông tin người dùng khác từ decodedToken nếu cần

            // Thực hiện các xử lý khác theo yêu cầu của bạn

            // Trả về thông tin người dùng
            User user = userService.getUserByUserName(username);
            if (user == null) {
                return new ResponseEntity<>("Người dùng không tồn tại", HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Lỗi: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        try {
            User user = userService.getUserByUserName(username);
            if (user == null) {
                throw new UserNotFoundException("User not found");
            }
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/role/{username}")
    public ResponseEntity<?> getRoleByUsername(@PathVariable String username) {
        try {
            User user = userService.getUserByUserName(username);
            if (user == null) {
                throw new UserNotFoundException("User not found");
            }
            return new ResponseEntity<>(user.getRole().getRoleName(), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/login/google/callback")
    public ResponseEntity<?> handleGoogleCallback(@AuthenticationPrincipal OAuth2User principal) {
        try {
            if (principal != null && isUserAuthenticated(principal)) {
                String username = principal.getAttribute("email");
                String name = principal.getAttribute("name");
                // Kiểm tra sự tồn tại của người dùng trong cơ sở dữ liệu
                User existingUser = userService.getUserByEmail(username);
                if (existingUser == null) {
                    // Tạo người dùng mới nếu không tồn tại
                    User user = new User();
                    user.setUsername(username);
                    user.setName(name);
                    user.setEmail(username);
                    String defaultPassword = "123";
                    String encodedPassword = new BCryptPasswordEncoder().encode(defaultPassword);
                    user.setPassword(encodedPassword);
                    userService.addUser(user);
                }
                // Trả về thông tin người dùng và token
                User userData = userService.getUserByEmail(username);
                String redirectUrl = "http://localhost:9998/a?token="+ jwtGenerator.generateToken(userData).get("token");
                // Chuyển hướng đến localhost:9998 cùng với token
                return ResponseEntity.status(HttpStatus.FOUND).header(HttpHeaders.LOCATION, redirectUrl).build();
//                return new ResponseEntity<>(jwtGenerator.generateToken(userData), headers, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Đăng nhập không thành công.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi: " + e.getMessage());
        }
    }

    private boolean isUserAuthenticated(OAuth2User principal) {
        return !CollectionUtils.isEmpty(principal.getAuthorities());
    }

//
//    @GetMapping("/login/google/callback")
//    public void handleGoogleCallback(@AuthenticationPrincipal OAuth2User principal, HttpServletResponse response, HttpServletRequest request) throws IOException {
//        if (principal != null && isUserAuthenticated(principal)) {
//            String username = principal.getAttribute("email");
//            String name = principal.getAttribute("name");
//
//            // Kiểm tra sự tồn tại của người dùng trong cơ sở dữ liệu
//            User existingUser = userService.getUserByEmail(username);
//            if (existingUser == null) {
//                // Tạo người dùng mới nếu không tồn tại
//                User user = new User();
//                user.setUsername(username);
//                user.setName(name);
//                user.setEmail(username);
//                String defaultPassword = "123";
//                String encodedPassword = new BCryptPasswordEncoder().encode(defaultPassword);
//                user.setPassword(encodedPassword);
//                userService.saveUser(user);
//            }
//
//            // Truy cập thông tin người dùng từ cơ sở dữ liệu
//            User userData = userService.getUserByUserName(username);
//
//            // Truyền giá trị userRepository cho CustomUserDetail
//            CustomUserDetail customUserDetail = new CustomUserDetail(userData, userRepository);
//            customUserDetail.setUserRepository(userRepository);
//
//            // Xác thực người dùng trong phiên làm việc hiện tại
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(customUserDetail, customUserDetail.getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//
//            // Lưu thông tin người dùng vào session để sử dụng sau này
//            HttpSession session = request.getSession();
//            session.setAttribute("username", username);
//            session.setAttribute("name", name);
//
//            // Chuyển hướng đến trang chủ của phần giao diện (localhost:9998)
//            response.sendRedirect("http://localhost:9998/");
//        } else {
//            // Xử lý trường hợp đăng nhập không thành công
//            response.sendRedirect("http://localhost:9998/login-failed");
//        }
//    }

    @PostMapping("/send-mail")
    public String sendMail(@RequestBody MailDetail mailDetail) {
        return mailService.sendMail(mailDetail.getRecipient(), mailDetail.getSubject(), mailDetail.getMsgBody());
    }

    //Sending email with attachment
    @PostMapping("/send-mail-attachment")
    public String sendMailWithAttachment(@RequestBody MailDetail mailDetail)
    {
        return mailService.sendMailWithAttachment(mailDetail);
    }

    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOTP(@RequestParam("email") String recipient) {
        try {

            User user = userService.getUserByEmail(recipient);
            if (user == null) {
                Map<String, String> response = new HashMap<>();
                response.put("error", "Người dùng không tồn tại");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            else {
                // Tạo OTP ngẫu nhiên
                String otp = RandomStringUtils.randomNumeric(6); // OTP có 6 chữ số

                // Lưu OTP và thời gian hết hạn vào session

                LocalDateTime now = LocalDateTime.now();
                LocalDateTime expirationTime = now.plusMinutes(5); // Thời gian hết hạn là 5 phút sau thời điểm hiện tại
                // Gửi OTP đến email
                String subject = "Mã OTP xác thực";
                String msgBody = "Mã OTP của bạn là: " + otp + " Mã của bạn có thời hạn 5 phút.";
                mailService.sendMail(recipient, subject, msgBody);
                Map<String, String> response = new HashMap<>();
                response.put("otp", otp);
                response.put("otpExpirationTime", expirationTime.toString());
                response.put("message", "OTP đã được gửi đến email. Vui lòng kiểm tra email.");

                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Lỗi: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestParam("email") String email, @RequestParam("newPassword") String newPassword) {
        try {
            // Xác thực thành công, thực hiện việc đổi mật khẩu cho người dùng
            User user = userService.getUserByEmail(email);
            if (user == null) {
                return new ResponseEntity<>("Người dùng không tồn tại", HttpStatus.NOT_FOUND);
            }

            // Cập nhật mật khẩu mới cho người dùng
            String encodedPassword = new BCryptPasswordEncoder().encode(newPassword);
            user.setPassword(encodedPassword);
            userService.saveUser(user);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Đổi mật khẩu thành công. Vui lòng đăng nhập");

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Lỗi: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
