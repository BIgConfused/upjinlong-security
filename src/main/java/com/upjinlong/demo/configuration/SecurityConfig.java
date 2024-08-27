package com.upjinlong.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

/*

    InMemoryUserDetailsManager Authentication
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        User user = new User("user", passwordEncoder.encode("password"), Collections.emptyList());
        return new InMemoryUserDetailsManager(user);
    }

*/

    /**
     * 加密方式配置
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        //optional: BcryptPasswordEncoder、Argon2PasswordEncoder、Pbkdf2PasswordEncoder、SCryptPasswordEncoder
        //obsolete、not encrypt：NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder(10);//密码强度默认10
    }

    /**
     * 默认的
     * http安全性，默认配置在这里 org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration
     */
/*    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //开启授权保护
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest()//对所有请求开启保护
                        .authenticated()//已认证请求会被自动授权
                )
                .formLogin(Customizer.withDefaults())//使用表单授权方式
                .httpBasic(Customizer.withDefaults());//使用基本授权方式
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }*/

    /**
     * 用作前后端分离，登录成功或失败可以返回对应json而不是返回页面
     * http安全性，默认配置在这里 org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration
     */
/*    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //开启授权保护
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest()//对所有请求开启保护
                        .authenticated()//已认证请求会被自动授权
                )
                .formLogin(from -> {
                    from
                            .successHandler(new LoginSuccessHandler())//配置登录成功处理器
                            .failureHandler(new LoginFailureHandler())//配置登录失败处理器
                    ;
                })
                .httpBasic(Customizer.withDefaults());//使用基本授权方式
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }*/

    /**
     * 登录失败跳转指定的后端页面
     * http安全性，默认配置在这里 org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //开启授权保护
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/loginFailureForward", "/Out").permitAll()//将登录失败跳转的接口和失败页面进行放行
                        .anyRequest()//对所有请求开启保护
                        .authenticated()//已认证请求会被自动授权
                )
                .formLogin(from -> {
                    from
                            .successHandler(new LoginSuccessHandler())//配置登录成功处理器
                            .failureForwardUrl("/loginFailureForward")//配置登录失败转发的接口
                    ;
                })
                .httpBasic(Customizer.withDefaults());//使用基本授权方式
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}