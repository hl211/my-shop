package cn.binux.admin.service.impl;

import cn.binux.admin.service.MenuService;
import cn.binux.constant.Const;
import cn.binux.mapper.ManagerRoleMapper;
import cn.binux.mapper.MenuMapper;
import cn.binux.pojo.Menu;
import cn.binux.pojo.MenuExample;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service(version = Const.E_SHOP_API_VERSION)
@Transactional
public class MenuServiceImpl implements MenuService {

    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    ManagerRoleMapper managerRoleMapper;

    /**
     * 获取用户的菜单
     *
     * @param managerId
     * @return
     */
    @Override

    public List<Menu> getMenuByManagerId(Integer managerId) {

        return menuMapper.selectMenuByManagerId(managerId);
    }

    /**
     * 获取用户对应权限的所有菜单Map集合
     *
     * @param managerId
     */
    @Override
    public Map<Menu, List<Menu>> getMenus(Integer managerId) {
        List<Menu> menus = getMenuByManagerId(managerId);
        Iterator<Menu> it = menus.iterator();
        Map<Menu, List<Menu>> map = new TreeMap<Menu, List<Menu>>();
        while (it.hasNext()) {
            Menu menu = it.next();
            MenuExample example = new MenuExample();
            MenuExample.Criteria criteria = example.createCriteria();
            criteria.andParentMenuEqualTo(menu.getMenuId());
            List<Menu> sons = menuMapper.selectByExample(example);
            map.put(menu, sons);
        }
        return map;
    }

    /**
     * 获取用户对应权限的菜单的Json格式字符串
     *
     * @param managerId
     */
    @Override
    public List<String> getMenuStr(Integer managerId) {
        List<Menu> menus = getMenuByManagerId(managerId);
        Iterator<Menu> it = menus.iterator();
        List<String> menuStr = new ArrayList<String>();
        while (it.hasNext()) {
            String str = "";
            Menu menu = it.next();
            str = str + "{id:'" + menu.getMenuId() + "',menu:[{text:'" + menu.getMenuName() + "',items:[";
            MenuExample example = new MenuExample();
            MenuExample.Criteria criteria = example.createCriteria();
            criteria.andParentMenuEqualTo(menu.getMenuId());
            List<Menu> sons = menuMapper.selectByExample(example);
            Iterator<Menu> itson = sons.iterator();
            while (itson.hasNext()) {
                Menu son = itson.next();
                if (son.getMenuStatus() != 0) {
                    str = str + "{id:'" + son.getMenuId() + "',text:'" + son.getMenuName() + "',href:'" + son.getMenuUrl() + "'},";
                }
            }
            str = str.substring(0, str.length() - 1);
            str = str + "]}]}";
            menuStr.add(str);
        }
        return menuStr;
    }

    /**
     * 获取所有菜单的集合
     */
    @Override
    public List<Menu> getAllMenus() {
        return null;
    }

    /**
     * 获取一条菜单信息
     *
     * @param menuId
     * @return
     */
    @Override
    public Menu getMenu(Integer menuId) {
        return null;
    }

    /**
     * 修改一条菜单信息
     *
     * @param menu
     * @param oldmenuId
     * @return
     */
    @Override
    public void editMenu(Menu menu, Integer oldmenuId) {

    }

    /**
     * 增加一条菜单信息
     *
     * @param menu
     * @return
     */
    @Override
    public void addMenu(Menu menu) {

    }

    /**
     * 删除一条菜单信息
     *
     * @param menuId
     * @return
     */
    @Override
    public void deleteMenu(Integer menuId) {

    }
}
