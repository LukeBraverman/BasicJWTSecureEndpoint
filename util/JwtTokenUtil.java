package com.payslip.util;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {



    //generate token for user
    public String generateToken(UserDetails userDetails) {

        return "Token";
    }
}
