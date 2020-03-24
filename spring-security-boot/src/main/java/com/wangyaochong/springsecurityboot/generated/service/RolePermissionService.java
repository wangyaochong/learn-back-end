package com.wangyaochong.springsecurityboot.generated.service;

import com.wangyaochong.springsecurityboot.generated.entity.RolePermission;

import java.util.List;

/**
 * (RolePermission)表服务接口
 *
 * @author makejava
 * @since 2020-03-24 08:25:43
 */
public interface RolePermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param  roleId 主键
     * @return 实例对象
     */
    List<RolePermission> queryById(Long roleId );

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RolePermission> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param rolePermission 实例对象
     * @return 实例对象
     */
    int insert(RolePermission rolePermission);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    boolean deleteById(Long roleId  );

}