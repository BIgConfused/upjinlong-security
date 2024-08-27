package com.upjinlong.demo.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upjinlong.demo.common.http.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

/**
 * login failure handler
 * response json format for failure
 */
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception
    ) throws IOException, ServletException {
        JsonObject result = new JsonObject(exception.getMessage());
        response.setHeader("Content-Type", "application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
