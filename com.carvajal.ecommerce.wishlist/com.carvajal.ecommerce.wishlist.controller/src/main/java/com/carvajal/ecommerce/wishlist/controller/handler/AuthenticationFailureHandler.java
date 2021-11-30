package com.carvajal.ecommerce.wishlist.controller.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	 @Override
     public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, 
                                         AuthenticationException exception) throws IOException, ServletException {
         super.onAuthenticationFailure(request, response, exception);
         if (exception.getClass().isAssignableFrom(UsernameNotFoundException.class)) {
             response.sendRedirect("User not found");
         } else if (exception.getClass().isAssignableFrom(LockedException.class)) {
             response.sendRedirect("User Locked");
         }
     }

}
