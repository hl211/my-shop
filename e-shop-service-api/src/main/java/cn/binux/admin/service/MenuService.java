package cn.binux.admin.service;

import cn.binux.pojo.Menu;

import java.util.List;
import java.util.Map;

public interface MenuService {

    /**
     * @param managerId
     * @return
     */
    public List<Menu> getMenuByManagerId(Integer managerId);

    /**
     * 获取用户对应权限的所有菜单Map集合
     *
     * @param managerId
     */
    Map<Menu, List<Menu>> getMenus(Integer managerId);

    /**
     * 获取用户对应权限的菜单的Json格式字符串
     *
     * @param managerId
     */
    List<String> getMenuStr(Integer managerId);

    /**
     * 获取所有菜单的集合
     *
     * @param
     */
    List<Menu> getAllMenus();

    /**
     * 获取一条菜单信息
     *
     * @param menuId
     * @return
     */
    Menu getMenu(Integer menuId);

    /**
     * 修改一条菜单信息
     *
     * @param menu
     * @return
     */
    void editMenu(Menu menu, Integer oldmenuId);

    /**
     * 增加一条菜单信息
     *
     * @param menu
     * @return
     */
    void addMenu(Menu menu);

    /**
     * 删除一条菜单信息
     *
     * @param menuId
     * @return
     */
    void deleteMenu(Integer menuId);
}
