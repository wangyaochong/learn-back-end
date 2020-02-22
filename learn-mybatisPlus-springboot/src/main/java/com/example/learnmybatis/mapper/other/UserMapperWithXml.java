package com.example.learnmybatis.mapper.other;


import com.example.learnmybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapperWithXml {
    /**
     * 新增用戶
     *
     * @param user
     * @return
     * @
     */
    int insertUser(User user, @Param("test") String test);

    /**
     * 修改用戶
     *
     * @param user
     * @param id
     * @return
     * @
     */
    int updateUser(User user, int id);

    /**
     * 刪除用戶
     *
     * @param id
     * @return
     * @
     */
    int deleteUser(int id);

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     * @
     */
    User selectUserById(int id);

    /**
     * 查询所有的用户信息
     *
     * @return
     * @
     */
    List<User> selectAllUser();


}
