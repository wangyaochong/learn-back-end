package com.example.shiro.config;

import com.example.shiro.realm.CustomerRealmSpringBoot;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;

@Configuration
public class ShiroConfig {
    public ShiroConfig() {
        System.out.println("ShiroConfig初始化");
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        HashMap<String, String> map = new HashMap<>();
        map.put("/user/login", "anon");
        map.put("/user/register", "anon");
        map.put("/register.jsp", "anon");
        map.put("/index.jsp", "authc");
        map.put("/**", "authc");//所有资源都需要认证授权
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        shiroFilterFactoryBean.setLoginUrl("/login.jsp");
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(Realm realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    @Bean
    public Realm realm() {
        CustomerRealmSpringBoot customerRealmSpringBoot = new CustomerRealmSpringBoot();
        HashedCredentialsMatcher md5 = new HashedCredentialsMatcher("md5");
        md5.setHashIterations(1024);
        customerRealmSpringBoot.setCredentialsMatcher(md5);
        customerRealmSpringBoot.setCacheManager(new MemoryConstrainedCacheManager());
        customerRealmSpringBoot.setAuthenticationCachingEnabled(true);//使用缓存
        customerRealmSpringBoot.setAuthenticationCacheName("AuthenticationCache");
        customerRealmSpringBoot.setAuthorizationCachingEnabled(true);
        customerRealmSpringBoot.setAuthorizationCacheName("AuthorizationCache");
        return customerRealmSpringBoot;
    }

}
