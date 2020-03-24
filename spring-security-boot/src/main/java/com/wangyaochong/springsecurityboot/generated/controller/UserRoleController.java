package com.wangyaochong.springsecurityboot.generated.controller;

import com.wangyaochong.springsecurityboot.generated.entity.UserRole;
import com.wangyaochong.springsecurityboot.generated.service.UserRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (UserRole)表控制层
 *
 * @author makejava
 * @since 2020-03-24 08:26:17
 */
@RestController
@RequestMapping("userRole")
public class UserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private UserRoleService userRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param userId 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserRole selectOne(Long userId) {
        return this.userRoleService.queryById(userId).get(0);
    }

}