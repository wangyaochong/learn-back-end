package com.wangyaochong.springsecurityboot.generated.entity;

import java.io.Serializable;

/**
 * (RolePermission)实体类
 *
 * @author makejava
 * @since 2020-03-24 08:25:43
 */
public class RolePermission implements Serializable {
    private static final long serialVersionUID = -39803536926405550L;
    
    private Long roleId;
    
    private Long permissionId;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

}