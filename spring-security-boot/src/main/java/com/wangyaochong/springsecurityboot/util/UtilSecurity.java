package com.wangyaochong.springsecurityboot.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author wangyaochong
 * @date 2020/3/24 09:32
 */
public class UtilSecurity {

    public static String getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal == null) {
            return null;
        }
        if (principal instanceof UserDetails) {
            UserDetails details = (UserDetails) principal;
            return details.getUsername();
        }
        return null;
    }
}
