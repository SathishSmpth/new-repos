package com.kamatchibotique.application.service;

import org.springframework.security.core.Authentication;

public interface JwtService {
    public String generateToken(Authentication authentication);
    public String getPhoneOrEmail(String token);
    public boolean validateToken(String token);
}
