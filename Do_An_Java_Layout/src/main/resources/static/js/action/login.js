
function login(username, password){
        var data = {
        username: username,
        password: password
      };
      fetch('http://localhost:9999/login?username='+username+'&password='+password, {
              method: "POST",

            }).then(response => {
                      if (response.ok) {
                      return response.json();
                      }
                      else{
                        alert('Thất bại');
                        }
                      })
              .then(result=>{

              });

      // Gửi yêu cầu đăng nhập đến server bằng fetch API
      fetch('http://localhost:9999/api/v1/user/login', {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
      })
      .then(response => {
//        if (response.ok) {
//          // Đăng nhập thành công
//          return response.json();
//        } else {
//          // Xử lý khi đăng nhập thất bại, ví dụ hiển thị thông báo lỗi
//          throw new Error("Login failed");
//
//        }
        return response.json();
      })
      .then(result => {
        if(result.error){
            alert(result.error);
            return;
        }
        var token = result.token;
        // Chuyển đến trang chủ hoặc trang khác sau khi đăng nhập thành công
        //window.location.href = "/home";

        console.log(token);
        // Lưu token vào Local Storage
        //        sessionStorage.token = token; localStorage.setItem('token', token);
        if (typeof (Storage) !== 'undefined') {
            sessionStorage.clear();
           sessionStorage.setItem('token', token);
        } else {
            alert('Trình duyệt của bạn không hỗ trợ!');
        }
        // Lấy user.name từ payload
        //const userName = decodedToken.username;
        location.reload();
      })
      .catch(error => {
        // Xử lý khi có lỗi xảy ra, ví dụ hiển thị thông báo lỗi
        console.log(error);
      });
   }

  function button_login(event) {
    event.preventDefault(); // Ngăn chặn hành động mặc định của form

    try {
      var username = $('.login-form').find('input[name="username"]').val();
      var password = $('.login-form').find('input[name="password"]').val();
        login(username,password);
    } catch (error) {
      console.log(error);
    }
  }

  function button_login(event) {
    event.preventDefault(); // Ngăn chặn hành động mặc định của form

    try {
      var username = $('.login-form').find('input[name="username"]').val();
      var password = $('.login-form').find('input[name="password"]').val();
        login(username,password);
    } catch (error) {
      console.log(error);
    }
  }

function button_logout(event) {
    event.preventDefault(); // Ngăn chặn hành động mặc định của form

    try {
      sessionStorage.removeItem('token');
      location.reload();
    } catch (error) {
      console.log(error);
    }
  }



function button_logout(event) {
    event.preventDefault(); // Ngăn chặn hành động mặc định của form

    try {
      sessionStorage.removeItem('token');
      window.location.href = "http://localhost:9998";
    } catch (error) {
      console.log(error);
    }
  }
//fetch("http://localhost:9999/api/v1/user/login/google/callback")
//          .then(response => {
//          console.log(response);
//            if (response.ok) {
//              // Đăng nhập thành công
//              return response.json();
//            } else {
//              // Xử lý khi đăng nhập thất bại, ví dụ hiển thị thông báo lỗi
//              throw new Error("Login failed");
//            }
//          })
//          .then(result => {
//            var token = result.token;
//            // Lưu token vào Session Storage
//            sessionStorage.clear();
//            sessionStorage.token = token;
//            // Chuyển hướng đến trang chủ hoặc trang khác
//            window.location.href = "http://localhost:9998";
//            Start();
//          })
//          .catch(error => {
//            // Xử lý khi có lỗi xảy ra, ví dụ hiển thị thông báo lỗi
//            console.log(error);
//          });

function loginWithGoogle() {
  const googleWindow = window.open("http://localhost:9999/oauth2/authorization/google", "_self");

  const checkLoginStatus = setInterval(() => {
    if (googleWindow.closed) {
      clearInterval(checkLoginStatus);

      // Kiểm tra xem trang hiện tại có phải là trang login thành công không
      const isCallbackPage = window.location.href.includes("http://localhost:9999/api/v1/user/login/google/callback");

      if (isCallbackPage) {
        // Gửi yêu cầu GET để kiểm tra token
        fetch("http://localhost:9999/api/v1/user/login/google/callback")
          .then(response => {
            if (response.ok) {
              // Đăng nhập thành công
              return response.json();
            } else {
              // Xử lý khi đăng nhập thất bại, ví dụ hiển thị thông báo lỗi
              throw new Error("Login failed");
            }
          })
          .then(result => {
            var token = result.token;
            // Lưu token vào Session Storage
            sessionStorage.clear();
            sessionStorage.setItem('token', token);            // Chuyển hướng đến trang chủ hoặc trang khác
            window.location.href = "http://localhost:9998/";
          })
          .catch(error => {
            // Xử lý khi có lỗi xảy ra, ví dụ hiển thị thông báo lỗi
            console.log(error);
          });
      }
    }
  }, 1000);
}



function sendOTP(event){
    event.preventDefault();
    const email = document.querySelector('input[name=email]').value;
    try{
    fetch('http://localhost:9999/api/v1/user/send-otp?email=' + email, {
            method: 'POST',
            headers: {
                      "Content-Type": "application/json"
                    }
        })
            .then(response => {
                    if (response.ok) {
                      // Gửi otp thành công
                      return response.json();
                    } else {
                      // Xử lý khi đăng nhập thất bại, ví dụ hiển thị thông báo lỗi
                      alert("Send otp failed");
                    }
                  })
                  .then(result => {
                    const otp = result.otp;
                    const otpExpirationTime = result.otpExpirationTime;
                    alert(result.message);
                    console.log(result.otpExpirationTime);
                    // Lưu otp vào Local Storage
                    //        sessionStorage.token = token; localStorage.setItem('token', token);
                    if (typeof (Storage) !== 'undefined') {
                        sessionStorage.clear();
                       sessionStorage.setItem('otp', otp);
                       sessionStorage.setItem('otpExpirationTime', otpExpirationTime);
                    } else {
                        alert('Trình duyệt của bạn không hỗ trợ!');
                    }
                  })
                  .catch(error => {
                    // Xử lý khi có lỗi xảy ra, ví dụ hiển thị thông báo lỗi
                    console.log(error);
                  });
    }catch(error )
    {
         console.log(error);
     }
}

function resetpass(event){
    event.preventDefault();
    const email = document.querySelector('input[name=email]').value;
    const newpassword = document.querySelector('input[name=newpassword]').value;
    const otp = document.querySelector('input[name=otp]').value;
    try{
    const expSession = sessionStorage.getItem('otpExpirationTime');
    const exp = new Date(expSession);

    const now = new Date();
    const otpSession= sessionStorage.getItem('otp');
    if(otp!=otpSession){
        alert('Otp không hợp lệ');
        return;
    }
    if (exp < now) {
      alert('OTP hết hạn');
      return;
    }


        fetch('http://localhost:9999/api/v1/user/change-password?email=' + email+'&otp='+otp+'&newPassword='+newpassword, {
                method: 'POST',
                headers: {
                          "Content-Type": "application/json"
                        }
            })

                .then(response => {
                        if(response.ok){
                        sessionStorage.removeItem('otp');
                        sessionStorage.removeItem('otpExpirationTime');
                        alert('Đã đổi mật khẩu thành công. Vui lòng đăng nhập.');
                        back(event);
                        return response.json();
                        }
                        else{
                        alert("Có lỗi.");
                        }
                    })
                    .then(data=>{
                        console.log(data);
                    })
                    .catch(error => {
                        console.log(error);
                    });
        }catch(error )
        {
             console.log(error);
         }
}