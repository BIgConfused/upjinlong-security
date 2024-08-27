package com.upjinlong.demo.module.account.web;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class LoginController {

    @PostMapping("/loginFailureForward")
    public String loginFailure(HttpServletResponse response) throws IOException {
        return "Out";
    }
}
