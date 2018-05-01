package cn.binux.admin.service.impl;

import cn.binux.admin.service.ManagerService;
import cn.binux.constant.Const;
import cn.binux.mapper.ManagerMapper;
import cn.binux.mapper.ManagerRoleMapper;
import cn.binux.pojo.*;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = Const.E_SHOP_API_VERSION)
@Transactional
public class ManagerServiceImpl implements ManagerService {
    private static final Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);


    @Autowired
    ManagerMapper managerMapper;
    @Autowired
    ManagerRoleMapper managerRoleMapper;
    /**
     * 添加一个管理员
     *
     * @param manager
     * @return
     */
    @Override
    public int addManager(Manager manager) {
        managerMapper.insertSelective(manager);
        return manager.getManagerId();
    }

    /**
     * 添加新加管理员的权限
     *
     * @param managerId
     * @param roleId
     * @return
     */
    @Override
    public void addPromission(Integer managerId, Integer roleId) {

    }

    /**
     * 修改管理员信息
     *
     * @param manager
     */
    @Override
    public void editManager(Manager manager) {
        managerMapper.updateByPrimaryKeySelective(manager);
    }

    /**
     * 通过id删除管理员
     *
     * @param managerId
     */
    @Override
    public void deleteManager(Integer managerId) {
//        删除用户
        managerMapper.deleteByPrimaryKey(managerId);
//        删除角色
        ManagerRoleExample example = new ManagerRoleExample();
        ManagerRoleExample.Criteria criteria = example.createCriteria();
        criteria.andManagerIdEqualTo(managerId);
        managerRoleMapper.deleteByExample(example);
    }

    /**
     * 通过管理员名称 获得管理员
     *
     * @param managerName
     * @return
     */
    @Override
    public Manager getManager(String managerName) {
        ManagerExample example = new ManagerExample();
        ManagerExample.Criteria criteria = example.createCriteria();
        criteria.andManagerNameEqualTo(managerName);
        List<Manager> managers = managerMapper.selectByExample(example);
        if (managers == null || managers.size() < 1) {
            return null;
        }
        return managers.get(0);
    }

    /**
     * 通过管理员id获得管理员
     *
     * @param managerId
     * @return
     */
    @Override
    public Manager getManager(Integer managerId) {
        return managerMapper.selectByPrimaryKey(managerId);
    }

    /**
     * 获取所有的管理员 数量较少 不采取分页
     *
     * @return
     */
    @Override
    public List<Manager> getManagers() {
        ManagerExample example = new ManagerExample();
        return managerMapper.selectByExample(example);
    }

    /**
     * 获取 查询出来的管理员
     *
     * @param manager
     * @return
     */
    @Override
    public List<Manager> getManagers(Manager manager) {
        return null;
    }

    /**
     * 获取 查询出来的管理员（带权限）
     *
     * @param
     * @return
     */
    @Override
    public List<ManagerPermission> getManagerPermissions() {
        return managerMapper.selectManagerPermission();
    }


    /**
     * 修改管理员的权限
     * @param managerRoleId
     * @param roleId
     */
    @Override
    public void changePromission(Integer managerRoleId, Integer roleId) {
        ManagerRole managerRole = new ManagerRole();
        managerRole.setManagerRoleId(managerRoleId);
        managerRole.setRoleId(roleId);
        managerRoleMapper.updateByPrimaryKeySelective(managerRole);
    }

    @Override
    public void addManagerOrRole(Manager manager, Integer roleId) {
        int managerId = addManager(manager);
        ManagerRole managerRole = new ManagerRole();
        managerRole.setManagerId(managerId);
        managerRole.setRoleId(roleId);
        managerRoleMapper.insertSelective(managerRole);

    }

    @Override
    public void editpasswd(Manager manager) {
        managerMapper.updateByPrimaryKeySelective(manager);
    }
}
