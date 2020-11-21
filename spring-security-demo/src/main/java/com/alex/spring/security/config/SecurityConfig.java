package com.alex.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/user/login")  //登录访问路径
                .defaultSuccessUrl("/test/index").permitAll()
                .and().authorizeRequests()
                .antMatchers("/", "/test/hello", "user/login").permitAll() //授权以上路径， 可以直接访问
                //1.当前登录的用户只有admin权限时才可以访问该路径
                //.antMatchers("/test/Authority").hasAuthority("admin")
                //2.当前登录的用户有任意一个权限时，都可以访问该路径
//                .antMatchers("/test/AnyAuthority").hasAnyAuthority("admin, guest")
                //3 用户拥有的角色时才可以访问
                //.antMatchers("/test/role").hasRole("sale")
                //4 用户拥有任意 角色时都可以访问
                .antMatchers("/test/anyRole").hasAnyRole("sale,manager")
                .anyRequest().authenticated()
                .and().csrf().disable(); //关闭CSRF
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
