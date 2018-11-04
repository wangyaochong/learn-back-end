package mapper;

import entity.UserM;

import java.util.List;

public interface UserMapperWithXml {
    /**
     * 新增用戶
     *
     * @param user
     * @return
     * @
     */
    int insertUser(UserM user);

    /**
     * 修改用戶
     *
     * @param user
     * @param id
     * @return
     * @
     */
    int updateUser(UserM user, int id);

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
    UserM selectUserById(int id);

    /**
     * 查询所有的用户信息
     *
     * @return
     * @
     */
    List<UserM> selectAllUser();
}
