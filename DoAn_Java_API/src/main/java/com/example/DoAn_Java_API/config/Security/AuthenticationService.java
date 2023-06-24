package com.example.DoAn_Java_API.config.Security;


import com.example.DoAn_Java_API.config.AuthenticationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service("authenticationService")
public class AuthenticationService {
    @Autowired
    AuthenticationConfig AuthenticationConfig;

    public boolean hasRole(String role) {
        System.out.println("role "+ role);
        Authentication authentication = AuthenticationConfig.AUTHENTICATION;
        System.out.println("annotation: "+authentication);
        System.out.println(authentication != null);
        if(authentication != null)
        System.out.println(authentication.getAuthorities().toString());
        boolean result = false;
        if (authentication != null) {
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                System.out.println("authority "+ authority.toString());
                System.out.println("authority "+ authority.getAuthority().toString());

                if (authority.getAuthority().equals(role)) {
                    result = true;
                    break;
                }
            }
        }
        System.out.println(result);
        return result;
    }
    public boolean hasRoleUSER() {

        Authentication authentication = AuthenticationConfig.AUTHENTICATION;
        System.out.println("annotation: "+authentication);
        System.out.println(authentication != null);
        if(authentication != null)
            System.out.println(authentication.getAuthorities().toString());
        boolean result= authentication != null && authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("USER") ||authority.getAuthority().equals("ADMIN"));
        return result;
    }
    public boolean hasRoleADMIN() {

        Authentication authentication = AuthenticationConfig.AUTHENTICATION;
        System.out.println("annotation: "+authentication);
        System.out.println(authentication != null);
        if(authentication != null)
            System.out.println(authentication.getAuthorities().toString());
        boolean result= authentication != null && authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ADMIN"));
        return result;
    }

}
