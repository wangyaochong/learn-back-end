package com.wangyaochong.springsecurityboot.generated.service;

import com.wangyaochong.springsecurityboot.generated.entity.UserRole;

import java.util.List;

/**
 * (UserRole)表服务接口
 *
 * @author makejava
 * @since 2020-03-24 08:26:17
 */
public interface UserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    List<UserRole> queryById(Long userId );

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    int insert(UserRole userRole);

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    UserRole update(UserRole userRole);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    boolean deleteById(Long userId );

}