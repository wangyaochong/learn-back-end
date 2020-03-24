package com.wangyaochong.springsecurityboot.Config;

import com.wangyaochong.springsecurityboot.generated.service.PermissionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

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

    @Resource
    PermissionService permissionService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        httpSecurity这个对象非常重要

//-----从数据库初始化权限，可以使用@PreAuthorize直接在controller上配置------------------
//        List<Permission> permissions = permissionService.queryAllByLimit(0, 100000);
//        for (Permission permission : permissions) {
//            http.authorizeRequests().antMatchers(permission.getUrl()).hasAuthority(permission.getCode());
//        }
//--------------------------从数据库初始化权限---------------------------


        http.csrf().disable()
                .authorizeRequests().antMatchers("/authTest").authenticated()
//                .antMatchers("/r1").hasAuthority("p1")
//                .antMatchers("/r2").hasAuthority("p2")
                .anyRequest().permitAll()
                .and().formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/login-view")
                .defaultSuccessUrl("/success")
                .failureForwardUrl("/login-fail")
                .successForwardUrl("/success")
//                配置退出
                .and().logout().logoutUrl("/logout")
                .logoutSuccessUrl("/login-view?logout");

        http.exceptionHandling().accessDeniedPage("/WEB-INF/jsp/403.jsp");
        //设置session规则，默认是IF_REQUIRED
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);

    }

}
