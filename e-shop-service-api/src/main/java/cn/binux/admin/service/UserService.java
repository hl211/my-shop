package cn.binux.admin.service;

import cn.binux.pojo.User;
import java.util.Map;

public interface UserService {

  /**
   * 登录成功返回 userId 返回为0则登录失败
   * @param username
   * @param password
   * @return
   */
   int userLogin(String username, String password);

  /**
   * 注册成功返回 用户id
   * @param user
   * @return
   */
  int userRegister(User user);

  /**
   * 通过Id 获取用户
   * @param userId
   * @return
   */
  User getUserById(Integer userId);

  /**
   * 通过id修改用户
   * @param user
   */
  void updateUserById(User user);

  /**
   * 获取 会员的分页信息
   * @param currPage
   * @param pageSize
   * @return
   */
  Map<String, Object> getUserPager(int currPage, int pageSize);
  /**
   * 进行模糊查询时调用的方法
   * @param currPage
   * @param pageSize
   * @param user
   * @return
   */

  Map<String, Object> getUserPager(int currPage,int pageSize,User user);

  /**
   * 修改用户
   * @param user
   */
  void editUser(User user);

  /**
   * 删除用户
   * @param userId
   */
  void deleteUser(int userId);

  /**
   * 通过用户名获取用户
   * @param username
   * @return
   */
  User getUserByUsername(String username);


}
