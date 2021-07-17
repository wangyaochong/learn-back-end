package com.example.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class CustomerMd5Realm extends AuthorizingRealm {
    @Override protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println();
        return null;
    }

    @Override protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Object principal = token.getPrincipal();
        System.out.println("用户名=" + principal);
        if("xiaochen".equals(principal)){
//            return new SimpleAuthenticationInfo(principal,"900150983cd24fb0d6963f7d28e17f72",
//                   this.getName()); //不加盐

//            //加盐方式
//            return new SimpleAuthenticationInfo(principal,"136ea9cdbe92ad28b07475c7f9dc29fa",
//                    ByteSource.Util.bytes("xgde"),this.getName());

            return new SimpleAuthenticationInfo(principal,"39c69329dc16a296ccc7497ba5cc5a5e",
                    ByteSource.Util.bytes("xgde"),this.getName());
        }
        return null;
    }
}
