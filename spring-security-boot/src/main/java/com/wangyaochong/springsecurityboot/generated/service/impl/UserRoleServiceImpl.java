package com.wangyaochong.springsecurityboot.generated.service.impl;

import com.wangyaochong.springsecurityboot.generated.dao.UserRoleDao;
import com.wangyaochong.springsecurityboot.generated.entity.UserRole;
import com.wangyaochong.springsecurityboot.generated.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserRole)表服务实现类
 *
 * @author makejava
 * @since 2020-03-24 08:26:17
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private UserRoleDao userRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param  userId 主键
     * @return 实例对象
     */
    @Override
    public List<UserRole> queryById( Long userId) {
        return this.userRoleDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserRole> queryAllByLimit(int offset, int limit) {
        return this.userRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(UserRole userRole) {
        return this.userRoleDao.insert(userRole);
    }

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole update(UserRole userRole) {
        this.userRoleDao.update(userRole);
        return this.queryById(userRole.getUserId()).get(0);
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long userId ) {
        return this.userRoleDao.deleteById() > 0;
    }

}