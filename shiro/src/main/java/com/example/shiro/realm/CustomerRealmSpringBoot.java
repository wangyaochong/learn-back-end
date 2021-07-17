package com.example.shiro.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shiro.generated.shiro.entity.*;
import com.example.shiro.generated.shiro.service.*;
import com.example.shiro.util.UtilApplicationContext;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerRealmSpringBoot extends AuthorizingRealm {
    UserRepo userRepo;
    RoleRepo roleRepo;
    UserRoleRepo userRoleRepo;
    PermRepo permRepo;
    RolePermRepo rolePermRepo;

    public void initRepo() {
        if (userRepo == null) {
            synchronized (CustomerRealmSpringBoot.class) {
                if (userRepo == null) {
                    userRepo = UtilApplicationContext.applicationContext.getBean(UserRepo.class);
                    roleRepo = UtilApplicationContext.applicationContext.getBean(RoleRepo.class);
                    userRoleRepo = UtilApplicationContext.applicationContext.getBean(UserRoleRepo.class);
                    permRepo = UtilApplicationContext.applicationContext.getBean(PermRepo.class);
                    rolePermRepo = UtilApplicationContext.applicationContext.getBean(RolePermRepo.class);
                }
            }
        }
    }

    public CustomerRealmSpringBoot() {
        System.out.println("CustomerRealmSpringBoot初始化");
    }

    @Override protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        System.out.println("验证权限，用户名=" + username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.addRole("admin");
//        simpleAuthorizationInfo.addStringPermission("user:*:01");
//        simpleAuthorizationInfo.addStringPermission("product:create");
        initRepo();
        User user = userRepo.findByUserName(username);
        List<UserRole> userRoles = userRoleRepo.list(new QueryWrapper<UserRole>().eq("user_id", user.getId()));
        List<Long> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList());
        if (roleIds.size() > 0) {
            Collection<Role> roles = roleRepo.listByIds(roleIds);
            for (Role role : roles) {
                simpleAuthorizationInfo.addRole(role.getName());
                List<RolePerm> rolePerms = rolePermRepo.list(new QueryWrapper<RolePerm>().eq("role_id", role.getId()));
                List<Long> permIds = rolePerms.stream().map(RolePerm::getPermId).collect(Collectors.toList());
                if (permIds.size() > 0) {
                    Collection<Perm> perms = permRepo.listByIds(permIds);
                    for (Perm perm : perms) {
                        simpleAuthorizationInfo.addStringPermission(perm.getName());
                    }
                }
            }
        }
        return simpleAuthorizationInfo;
    }

    @Override protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
//        System.out.println("用户名=" + principal);
//        if("xiaochen".equals(principal)){
//            return new SimpleAuthenticationInfo(principal,"123",this.getName());
//        }
        initRepo();
        User user = userRepo.findByUserName(userName);
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(userName, user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()), this.getName());
    }
}
