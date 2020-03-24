package com.wangyaochong.springsecurityboot.generated.controller;

import com.wangyaochong.springsecurityboot.generated.entity.Role;
import com.wangyaochong.springsecurityboot.generated.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Role)表控制层
 *
 * @author makejava
 * @since 2020-03-24 08:25:01
 */
@RestController
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Role selectOne(Long id) {
        return this.roleService.queryById(id);
    }

}