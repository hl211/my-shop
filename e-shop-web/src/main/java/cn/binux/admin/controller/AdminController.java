package cn.binux.admin.controller;

import cn.binux.admin.service.ManagerService;
import cn.binux.admin.service.MenuService;
import cn.binux.admin.service.UserService;
import cn.binux.constant.Const;
import cn.binux.pojo.Manager;
import cn.binux.pojo.ManagerPermission;
import cn.binux.pojo.Menu;
import cn.binux.pojo.User;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Admin 首页Controller
 *
 * @author
 * @create
 */

@Controller
@RequestMapping("back")
public class AdminController {

    @Reference(version = Const.E_SHOP_API_VERSION)
    private UserService userService;

    @Reference(version = Const.E_SHOP_API_VERSION)
    private ManagerService managerService;

    @Reference(version = Const.E_SHOP_API_VERSION)
    private MenuService menuService;

    
    @RequestMapping("/index")
    public String index() {

        return "back/login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(String managerName, String managerPassword, HttpServletRequest request,
                                     HttpServletResponse response) {
        Manager manager = null;
        try {
            manager = managerService.getManager(managerName);
        } catch (Exception e) {
            System.out.println("没有查询到该用户");
        }
        Map result = new HashMap<>();
        if (manager == null || !managerPassword.equals(manager.getManagerPassword())) {
            result.put("check", "checkout");
        } else {
            result.put("check", "checkin");
            request.getSession().setAttribute("manager", manager);
        }
        return result;
    }

    @RequestMapping("/main")
    public String main(Model model, HttpServletRequest request,
                       HttpServletResponse response) {
        HttpSession session = request.getSession();
        Manager manager = (Manager) session.getAttribute("manager");
        List<Menu> menumap = menuService.getMenuByManagerId(manager.getManagerId());
        String array = JSON.toJSONString(menumap);
        model.addAttribute("menumap", array);
        //获取所有父子菜单字符串集合，主页获取后显示菜单项
        List<String> menuStr = menuService.getMenuStr(manager.getManagerId());
        model.addAttribute("menuStr", menuStr);
        return "back/main";
    }

    // 退出时经过此方法跳转
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "back/login";
    }


    // 获取所有的管理员账户
    @RequestMapping("/Admin/getManagers.html")
    public String getManagers(Model model) throws IOException {
        List<Manager> managers = managerService.getManagers();
        model.addAttribute("managers", JSON.toJSONString(managers));
        System.out.println("---------------------------------------------------------");
        return "back/Admin/index";
    }

    // 删除管理员账户
    @RequestMapping("/Admin/deleteManager")
    public String deleteManager(Model model, Integer managerId) throws IOException {
        try {
            managerService.deleteManager(managerId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取managerId失败");
        }
        return getManagers(model);
    }

    // 转发到管理员修改的edit页面
    @RequestMapping("/Admin/EditManager.html")
    public String toEditManager(Model model, Integer managerId) {
        Manager manager = managerService.getManager(managerId);
        model.addAttribute("manager", manager);
        return "back/Admin/edit";
    }

    // 修改管理员账户
    @RequestMapping("/Admin/editManager")
    @ResponseBody
    public String editManager(Integer managerId, String managerPassword) throws IOException {
        Manager manager = new Manager();
        manager.setManagerId(managerId);
        manager.setManagerPassword(managerPassword);
        managerService.editManager(manager);
        return "修改成功";
    }

    // 增加管理员账户
    @RequestMapping("/Admin/toaddManager")
    public String toAddManager() {
        return "back/Admin/add";
    }

    // 增加一个管理员账户
    @RequestMapping("/Admin/addManager")
    @ResponseBody
    public String addManager(String managerName, String managerPassword, Integer roleId) throws IOException {

        try {
            Manager oldManager = managerService.getManager(managerName);
            if (oldManager != null
                    && oldManager.getManagerName().equals(managerName)) {
                return "用户名已存在！";
            }
            //插入管理员
            Manager manager = new Manager();
            manager.setManagerName(managerName);
            manager.setManagerPassword(managerPassword);
            managerService.addManagerOrRole(manager, roleId);
        } catch (Exception e) {
            e.printStackTrace();
            return "添加失败,发生异常";
        }
        return "添加成功";
    }

    // 获取所有管理员的权限列表
    @RequestMapping("/Admin/togetPermissions")
    public String togetPermissions(Model model) throws IOException {

        List<ManagerPermission> managerPermission = managerService.getManagerPermissions();
        model.addAttribute("managerPermission", JSON.toJSONString(managerPermission));
        return "back/Admin/promission";
    }

    @RequestMapping("/Admin/changePromission")
    @ResponseBody
    public String changePromission(Model model, Integer manageroleId, Integer roleId) throws IOException {
        managerService.changePromission(manageroleId, roleId);
        return "修改成功";
    }

    //菜单首页
    @RequestMapping("/Menu/togetMenus")
    public String togetMenus(Model model) {
        List<Menu> menus = menuService.getAllMenus();
        model.addAttribute("menus", JSON.toJSONString(menus));
        return "back/Menu/index";
    }

    //删除菜单
    @RequestMapping("/Menu/deleteMenu")
    public String deleteMenu(Model model, Integer menuId) throws IOException {
        try {
            menuService.deleteMenu(menuId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取managerId失败");
        }
        return togetMenus(model);
    }

    //跳转到添加菜单页
    @RequestMapping("/Menu/toaddMenu")
    public String toAddMenu() {
        return "/back/Menu/add";
    }

    // 添加菜单
    @RequestMapping("/Menu/addMenu")
    @ResponseBody
    public String addMenu(Menu menu) {
        try {
            menuService.addMenu(menu);
        } catch (Exception e) {
            return "编码已存在";
        }
        return "添加成功";
    }

    //跳转到编辑菜单页
    @RequestMapping("/Menu/toEditMenu")
    public String toEditMenu(Model model, Integer menuId) {
        Menu menu = menuService.getMenu(menuId);
        model.addAttribute("menu", menu);
        return "back/Menu/edit";
    }

    //编辑菜单页
    @RequestMapping("/Menu/editMenu")
    @ResponseBody
    public String EditMenu(Model model, Menu menu, Integer oldmenuId) {
        menuService.deleteMenu(oldmenuId);
        return addMenu(menu);
    }


    //会员首页
    @RequestMapping("/User/togetUsers")
    public String togetUsers(Model model) {
        List<User> users = userService.getUserPager();
        model.addAttribute("users", JSON.toJSONString(users));
        return "back/User/index";
    }


    //跳转到编辑用户页
    @RequestMapping("/User/toEditUser")
    public String toEditUser(Model model, Integer userId) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "back/User/edit";
    }

}
