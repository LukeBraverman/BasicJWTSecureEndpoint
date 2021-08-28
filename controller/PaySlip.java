package com.payslip.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaySlip {

    @PostMapping("/Auth")
    public void authenticate( ) {

    }

    @GetMapping("/Payslip")
    public String getPaySlip() {
        String JsonPayslip = null;
        return JsonPayslip;
    }
}
