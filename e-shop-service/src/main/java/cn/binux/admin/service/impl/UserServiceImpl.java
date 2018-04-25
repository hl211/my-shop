package cn.binux.admin.service.impl;

import cn.binux.admin.service.UserService;
import cn.binux.constant.Const;
import cn.binux.mapper.UserMapper;
import cn.binux.pojo.User;
import cn.binux.pojo.UserExample;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service(version = Const.E_SHOP_API_VERSION)
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录成功返回 userId 返回为0则登录失败
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public int userLogin(String username, String password) {
        return 0;
    }

    /**
     * 注册成功返回 用户id
     *
     * @param user
     * @return
     */
    @Override
    public int userRegister(User user) {
        int res = userMapper.insertSelective(user);
        if (res < 0) {
            return 0;
        }
        return user.getUserId();
    }

    /**
     * 通过Id 获取用户
     *
     * @param userId
     * @return
     */
    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * 通过id修改用户
     *
     * @param user
     */
    @Override
    public void updateUserById(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 获取 会员的分页信息
     *
     * @param currPage
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> getUserPager(int currPage, int pageSize) {
        return null;
    }

    /**
     * 进行模糊查询时调用的方法
     *
     * @param currPage
     * @param pageSize
     * @param user
     * @return
     */
    @Override
    public Map<String, Object> getUserPager(int currPage, int pageSize, User user) {
        return null;
    }

    /**
     * 修改用户
     *
     * @param user
     */
    @Override
    public void editUser(User user) {

    }

    /**
     * 删除用户
     *
     * @param userId
     */
    @Override
    public void deleteUser(int userId) {

    }

    /**
     * 通过用户名获取用户
     *
     * @param username
     * @return
     */
    @Override
    public User getUserByUsername(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        if (users == null || users.size() == 0) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public List<User> getUserPager() {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        return userMapper.selectByExample(example);
    }
}
