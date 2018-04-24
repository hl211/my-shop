package cn.binux.admin.service;

import cn.binux.pojo.Manager;
import cn.binux.pojo.ManagerPermission;

import java.util.List;

public interface ManagerService {
    /**
     * 添加一个管理员
     * @param manager
     * @return
     */
    int addManager(Manager manager);

    /**
     * 添加新加管理员的权限
     * @param manager
     * @return
     */
    void addPromission(int managerId, int roleId);

    /**
     * 修改管理员信息
     * @param manager
     */
    void editManager(Manager manager);

    /**
     * 通过id删除管理员
     * @param managerId
     */
    void deleteManager(int managerId);

    /**
     * 通过管理员名称 获得管理员
     * @param managerName
     * @return
     */
    Manager getManager(String managerName);

    /**
     * 通过管理员id获得管理员
     * @param managerId
     * @return
     */
    Manager getManager(int managerId);

    /**
     * 获取所有的管理员 数量较少 不采取分页
     * @return
     */
    List<Manager> getManagers();
    /**
     * 获取 查询出来的管理员
     * @param manager
     * @return
     */
    List<Manager> getManagers(Manager manager);
    /**
     * 获取 查询出来的管理员（带权限）
     * @param manager
     * @return
     */
    List<ManagerPermission> getManagerPermissions(Manager manager);

    /**
     * 修改管理员的权限
     * @param managerId
     * @param roleId
     */
    void changePromission(int managerId, int roleId);

}
