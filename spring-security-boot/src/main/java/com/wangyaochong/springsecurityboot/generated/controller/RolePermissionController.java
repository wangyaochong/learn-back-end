package com.wangyaochong.springsecurityboot.generated.controller;

import com.wangyaochong.springsecurityboot.generated.entity.RolePermission;
import com.wangyaochong.springsecurityboot.generated.service.RolePermissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (RolePermission)表控制层
 *
 * @author makejava
 * @since 2020-03-24 08:25:43
 */
@RestController
@RequestMapping("rolePermission")
public class RolePermissionController {
    /**
     * 服务对象
     */
    @Resource
    private RolePermissionService rolePermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param roleId 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RolePermission selectOne(Long roleId) {
        return this.rolePermissionService.queryById(roleId).get(0);
    }

}