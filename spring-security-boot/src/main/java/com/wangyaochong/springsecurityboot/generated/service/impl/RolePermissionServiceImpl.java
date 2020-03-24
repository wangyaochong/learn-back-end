package com.wangyaochong.springsecurityboot.generated.service.impl;

import com.wangyaochong.springsecurityboot.generated.dao.RolePermissionDao;
import com.wangyaochong.springsecurityboot.generated.entity.RolePermission;
import com.wangyaochong.springsecurityboot.generated.service.RolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RolePermission)表服务实现类
 *
 * @author makejava
 * @since 2020-03-24 08:25:43
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {
    @Resource
    private RolePermissionDao rolePermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param  roleId 主键
     * @return 实例对象
     */
    @Override
    public List<RolePermission> queryById(Long roleId ) {
        return this.rolePermissionDao.queryById( roleId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<RolePermission> queryAllByLimit(int offset, int limit) {
        return this.rolePermissionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param rolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(RolePermission rolePermission) {
        return this.rolePermissionDao.insert(rolePermission);
    }



    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long roleId ) {
        return this.rolePermissionDao.deleteById(roleId) > 0;
    }
}