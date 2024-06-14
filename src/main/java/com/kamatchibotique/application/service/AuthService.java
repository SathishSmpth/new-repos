package com.kamatchibotique.application.service;


import com.kamatchibotique.application.dto.request.ForgotPasswordDto;
import com.kamatchibotique.application.dto.request.LoginDto;
import com.kamatchibotique.application.dto.request.RegisterDto;
import com.kamatchibotique.application.dto.request.ResetPasswordDto;
import com.kamatchibotique.application.dto.response.JwtResponse;
import com.kamatchibotique.application.dto.response.SuccessResponse;

public interface AuthService {

    JwtResponse login(LoginDto loginDto);

    SuccessResponse register(RegisterDto registerDto);

    SuccessResponse forgotPassword(ForgotPasswordDto forgotPasswordDto);

    SuccessResponse resetPassword(String passwordResetToken, ResetPasswordDto resetPasswordDto);

    String getAuthenticatedUsername();
}
