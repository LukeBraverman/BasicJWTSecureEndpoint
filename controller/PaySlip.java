package com.payslip.controller;

import com.payslip.model.Authentication;
import com.payslip.model.JwtToken;
import com.payslip.service.MyUserDetailsService;
import com.payslip.util.JwtTokenUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PaySlip {


    private AuthenticationManager authenticationManager;


    private JwtTokenUtil jwtTokenUtil;

    private MyUserDetailsService myUserDetailsService;

    @PostMapping("/Auth")
    public ResponseEntity<JwtToken> authenticate(@RequestBody Authentication authentication) throws Exception {
        System.out.println(authentication.getUsername());
        System.out.println(authentication.getPassword());
      try {
          authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authentication.getUsername(),
                  authentication.getPassword()));

      }catch (DisabledException e) {
          throw new Exception("USER_DISABLED", e);
      } catch (BadCredentialsException e) {
          throw new Exception("INVALID_CREDENTIALS", e);
      }

      final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authentication.getUsername());


        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtToken(token));
    }

    @GetMapping("/Payslip")
    public String getPaySlip() {
        String JsonPayslip = "PAYSLIP: $100";
        return JsonPayslip;
    }
}
