package com.wangyaochong.springsecurityboot;

import com.wangyaochong.springsecurityboot.generated.entity.RolePermission;
import com.wangyaochong.springsecurityboot.generated.entity.UserRole;
import com.wangyaochong.springsecurityboot.generated.service.PermissionService;
import com.wangyaochong.springsecurityboot.generated.service.RolePermissionService;
import com.wangyaochong.springsecurityboot.generated.service.UserRoleService;
import com.wangyaochong.springsecurityboot.generated.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangyaochong
 * @date 2020/3/23 15:37
 */
@Service
@Slf4j
public class MyUserDetailServiceImpl implements UserDetailsService {
    @Resource
    UserService userService;
    @Resource
    UserRoleService userRoleService;
    @Resource
    RolePermissionService rolePermissionService;
    @Resource
    PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<com.wangyaochong.springsecurityboot.generated.entity.User> users = userService.queryByName(username);
        com.wangyaochong.springsecurityboot.generated.entity.User user = users.get(0);
        log.info("用户查寻成功 user=" + user);
        log.info("" + userService.queryById(user.getId()));
        List<UserRole> userRoles = userRoleService.queryById(user.getId());
        User.UserBuilder builder = User.withUsername(user.getUsername()).password(user.getPassword());
        for (UserRole userRole : userRoles) {
            List<RolePermission> rolePermissions = rolePermissionService.queryById(userRole.getRoleId());
            for (RolePermission rolePermission : rolePermissions) {
                builder.authorities(permissionService.queryById(rolePermission.getPermissionId()).getCode());
            }
        }
        return builder.build();
    }


}
