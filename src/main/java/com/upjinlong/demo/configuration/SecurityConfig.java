package com.upjinlong.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Collections;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        User user = new User("user", passwordEncoder.encode("password"), Collections.emptyList());
        return new InMemoryUserDetailsManager(user);
    }

    /**
     * 加密方式
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        //optional: BcryptPasswordEncoder、Argon2PasswordEncoder、Pbkdf2PasswordEncoder、SCryptPasswordEncoder
        //obsolete、not encrypt：NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder(10);//密码强度默认10
    }

}