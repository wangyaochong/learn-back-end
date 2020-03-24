package com.wangyaochong.springsecurityboot.generated.controller;

import com.wangyaochong.springsecurityboot.generated.entity.Permission;
import com.wangyaochong.springsecurityboot.generated.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Permission)表控制层
 *
 * @author makejava
 * @since 2020-03-23 22:36:06
 */
@RestController
@RequestMapping("permission")
public class PermissionController {
    /**
     * 服务对象
     */
    @Resource
    private PermissionService permissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Permission selectOne(Long id) {
        return this.permissionService.queryById(id);
    }

}