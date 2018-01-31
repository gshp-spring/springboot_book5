package com.jeweltot.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
            /**
             * 로그인된 사용자가 요청할 때, 사용자가 인증되지 않았다면
             * 스프링 시큐리티 필터는 요청을 잡아내고 사용자를 로그인페이지로 리다이렉션 해준다.
             */
            .antMatchers("/**").authenticated()
            .and()
            .formLogin().loginPage("/login").permitAll()
            .and()
            .logout().permitAll()
            .and()
            .csrf().disable();
    }

    @Configuration
    static protected class LoginController extends WebMvcConfigurerAdapter
    {
        @Override
        public void addViewControllers(ViewControllerRegistry registry)
        {
            registry.addViewController("/login").setViewName("login");
        }
    }
}
