package cn.binux.admin.service.impl;

import cn.binux.admin.service.ManagerService;
import cn.binux.constant.Const;
import cn.binux.mapper.ManagerMapper;
import cn.binux.pojo.Manager;
import cn.binux.pojo.ManagerExample;
import cn.binux.pojo.ManagerPermission;
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

    /**
     * 添加一个管理员
     *
     * @param manager
     * @return
     */
    @Override
    public int addManager(Manager manager) {
        return 0;
    }

    /**
     * 添加新加管理员的权限
     *
     * @param managerId
     * @param roleId
     * @return
     */
    @Override
    public void addPromission(int managerId, int roleId) {

    }

    /**
     * 修改管理员信息
     *
     * @param manager
     */
    @Override
    public void editManager(Manager manager) {

    }

    /**
     * 通过id删除管理员
     *
     * @param managerId
     */
    @Override
    public void deleteManager(int managerId) {

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
    public Manager getManager(int managerId) {
        return null;
    }

    /**
     * 获取所有的管理员 数量较少 不采取分页
     *
     * @return
     */
    @Override
    public List<Manager> getManagers() {
        return null;
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
     * @param manager
     * @return
     */
    @Override
    public List<ManagerPermission> getManagerPermissions(Manager manager) {
        return null;
    }

    /**
     * 修改管理员的权限
     *
     * @param managerId
     * @param roleId
     */
    @Override
    public void changePromission(int managerId, int roleId) {

    }
}
