package com.payslip.controller;

import com.payslip.model.Authentication;
import com.payslip.model.JwtToken;
import com.payslip.util.JwtTokenUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PaySlip {

    JwtTokenUtil jwtTokenUtil;


    @PostMapping("/Auth")
    public ResponseEntity<JwtToken> authenticate(@RequestBody Authentication authentication) {


        final String token = jwtTokenUtil.generateToken(null);
        return ResponseEntity.ok(new JwtToken(token));
    }

    @GetMapping("/Payslip")
    public String getPaySlip() {
        String JsonPayslip = null;
        return JsonPayslip;
    }
}
