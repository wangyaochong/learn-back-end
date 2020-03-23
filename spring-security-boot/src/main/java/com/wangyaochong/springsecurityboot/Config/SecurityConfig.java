package com.wangyaochong.springsecurityboot.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author wangyaochong
 * @date 2020/3/23 14:58
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//这一段加密专用
//
//    @Override
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        manager.createUser(User.withUsername("zhangsan").
//                password(bCryptPasswordEncoder.encode("123")).authorities("p1").build());
//        manager.createUser(User.withUsername("lisi")
//                .password(bCryptPasswordEncoder.encode("456")).authorities("p2").build());
//        return manager;
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


//    @Override
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        manager.createUser(User.withUsername("zhangsan").
//                password("123").authorities("p1").build());
//        manager.createUser(User.withUsername("lisi")
//                .password("456").authorities("p2").build());
//        return manager;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().antMatchers("/authTest").authenticated()
                .antMatchers("/r1").hasAuthority("p1")
                .antMatchers("/r2").hasAuthority("p2")
                .anyRequest().permitAll()
                .and().formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/login-view")
                .defaultSuccessUrl("/success")
                .failureForwardUrl("/login-fail")
                .successForwardUrl("/success");
    }
}
