package com.payslip.model;

public class JwtToken {

    private final String jwtToken;

    public JwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }
}
