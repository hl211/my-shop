package cn.binux.admin.controller;

import cn.binux.admin.service.ManagerService;
import cn.binux.admin.service.MenuService;
import cn.binux.admin.service.UserService;
import cn.binux.constant.Const;
import cn.binux.pojo.Manager;
import cn.binux.pojo.ManagerPermission;
import cn.binux.pojo.Menu;
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
 * @author xubin.
 * @create 2017-02-11 下午3:38
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
    @RequestMapping("/Admin/togetManagers")
    public String getManagers(Model model) throws IOException {
        List<Manager> managers = managerService.getManagers();
        model.addAttribute("managers", JSON.toJSONString(managers));
        return "/back/Admin/index";
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
    @RequestMapping("Admin/toEditManager")
    public String toEditManager(Model model, Integer managerId) {
        Manager manager = managerService.getManager(managerId);
        model.addAttribute("manager", manager);
        return "/back/Admin/edit";
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
        return "/back/Admin/add";
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
        return "/back/Admin/promission";
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
        return "/back/Menu/index";
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
        return "/back/Menu/edit";
    }

    //编辑菜单页
    @RequestMapping("/Menu/editMenu")
    @ResponseBody
    public String EditMenu(Model model, Menu menu, Integer oldmenuId) {
        menuService.deleteMenu(oldmenuId);
        return addMenu(menu);
    }

//    @Reference(version = Const.XBIN_STORE_API_VERSION)
//    private UserService userService;
//
//    @Reference(version = Const.XBIN_STORE_API_VERSION)
//    private RoleService roleService;
//
//    @Reference(version = Const.XBIN_STORE_API_VERSION)
//    private UserRoleService userRoleService;
//
//
//    private Random random = new Random();
//
//    @RequestMapping("/index")
//    public String showIndex(Model model) {
//
//        ManageUserVO userVO = new ManageUserVO();
//        userVO.setCreated(new Date());
//        userVO.setName("許彬");
//        userVO.setJob("CEO");
//
//        model.addAttribute("user", userVO);
//
//        return "index";
//    }
//    @RequestMapping("/admin")
//    public String showAdmin(Model model) {
//
//        ManageUserVO userVO = new ManageUserVO();
//        userVO.setCreated(new Date());
//        userVO.setName("李辉");
//        userVO.setJob("CEO");
//
//        model.addAttribute("user", userVO);
//
//        return "admin";
//    }
//
//    @RequestMapping("/admin1")
//    public String showAdmin1(Model model) {
//
//        ManageUserVO userVO = new ManageUserVO();
//        userVO.setCreated(new Date());
//        userVO.setName("李辉");
//        userVO.setJob("CEO");
//
//        model.addAttribute("user", userVO);
//
//        return "admin1";
//    }
//    @RequestMapping("/show/logo")
//    public String showLogo(Model model) {
//        int nub = random.nextInt(60000);
//
//        model.addAttribute("random", nub);
//
//        return "editlogo";
//    }
//
//    @RequestMapping("/show/eidtItem")
//    public String showEidtItem(Model model) {
//        int nub = random.nextInt(60000);
//
//        model.addAttribute("random", nub);
//
//        return "editItem";
//    }
//
//    @RequestMapping("/show/addItem")
//    public String showAddItem(Model model) {
//        int nub = random.nextInt(60000);
//
//        model.addAttribute("random", nub);
//
//        return "addItem";
//    }
//    @RequestMapping("/show/category")
//    public String showCategory(Model model) {
//        int nub = random.nextInt(60000);
//        model.addAttribute("random", nub);
//
//        return "category";
//    }
//
//
//    @RequestMapping("/show/userManagement")
//    public String showuserManagement(Model model) {
//        int nub = random.nextInt(60000);
//        model.addAttribute("random", nub);
//
//        return "../pages/userManagement";
//    }
//
//    /**
//     * describe: TODO user
//     * creat_user: hl
//     * creat_date: 2018-04-02
//     * creat_time: 21:32
//     **/
//    @RequestMapping(value = "/user" , method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> getUserData(Integer pageIndex, Integer pageSize) {
//        //获取用户
//        Map<String, Object> map= userService.getSysUserList(pageIndex,pageSize);
//        //获取用户对应的角色
//        ArrayList list=(ArrayList)map.get("aData");
//        for (Object o:list){
//            Long uid=((SysUser)o).getUserId();
//            ((SysUser)o).setRoles(roleService.getSysRoleByUserId(uid.intValue()));
//        }
//        return map;
//    }
//    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
//    @ResponseBody
//    public XbinResult addUserData(String userAccount, String userPass,
//                                  String userTel, String userEmail, String userSex,
//                                  String userStatus, HttpServletRequest request) {
//        String[] ids=request.getParameterValues("RoleId[]");
//        //添加该用户
//        SysUser sysUser=new SysUser();
//        sysUser.setUserAccount(userAccount);
//        sysUser.setUserPass(userPass);
//        sysUser.setUserTel(userTel);
//        sysUser.setUserEmail(userEmail);
//        sysUser.setUserStatus(Integer.valueOf(userStatus));
//        sysUser.setUserSex(Integer.valueOf(userSex));
//        sysUser.setUserRegisterDate(new Date().toString());
//
//        XbinResult xbinResult=userService.saveSysUser(sysUser);
//        //添加角色为该用户
//        boolean flag=true;
//        if(xbinResult.isOK()){
//            Long uid=(Long) xbinResult.getData();
//            for(String id:ids) {
//                SysUserRole sysUserRole=new SysUserRole();
//                sysUserRole.setUserId(uid);
//                sysUserRole.setRoleId(Integer.valueOf(id));
//                if(!userRoleService.saveSysUserRole(sysUserRole).isOK()){
//                    flag=false;
//                    continue;
//
//                }
//            }
//        }
//        return flag==true?XbinResult.ok():XbinResult.build(400,"error");
//    }
//    @RequestMapping(value = "/user/delete",method = RequestMethod.POST)
//    @ResponseBody
//    public XbinResult delUserData( String ids) {
//        if(ids!=null) {
//        String[] uids=ids.split(",");
//
//        //先删除角色
//        userRoleService.deleteSysUserRoleByUid(uids);
//        //删除用户
//        XbinResult result = userService.deleteSysUserById(uids);
//            return result;
//        }
//        return XbinResult.build(400,"ids为空");
//    }
//
//    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
//    @ResponseBody
//    public XbinResult updateUserData(Model model, String IDS) {
//        String[] list=IDS.split(",");
//        XbinResult result = userService.deleteSysUserById(list);
//        return result;
//    }
//
//    /**
//     * describe: TODO Role
//     * creat_user: hl
//     * creat_date: 2018-04-02
//     * creat_time: 21:48
//     **/
//    @RequestMapping(value = "/role" , method = RequestMethod.GET)
//    @ResponseBody
//    public Map<String, Object> getRoleData(Integer pageIndex, Integer pageSize) {
//        Map<String, Object> lists = roleService.getSysRoleList(pageIndex,pageSize);
//        return lists;
//    }
//    @RequestMapping(value = "/role/all" , method = RequestMethod.GET)
//    @ResponseBody
//    public Map<String, Object> getRoleAllData(Integer pageIndex, Integer pageSize) {
//        Map<String, Object> lists = roleService.getSysRoleAll();
//        return lists;
//    }
//    @RequestMapping(value = "/role/add", method = RequestMethod.POST)
//    @ResponseBody
//    public XbinResult addRoleData(SysRole sysRole) {
//        XbinResult result = roleService.saveSysRole(sysRole);
//        return result;
//    }
//    @RequestMapping(value = "/role/delete",method = RequestMethod.POST)
//    @ResponseBody
//    public XbinResult delRoleData( String IDS) {
//        String[] list=IDS.split(",");
//        XbinResult result = roleService.deleteSysRoleById(list);
//        return result;
//    }
//    @RequestMapping(value = "/role/update",method = RequestMethod.POST)
//    @ResponseBody
//    public XbinResult updateRoleData(Model model,SysRole sysRole) {
//        XbinResult result = roleService.saveSysRole(sysRole);
//        return result;
//    }
///**
// * describe: TODO  permission
// * creat_user: hl
// * creat_date: 2018-04-02
// * creat_time: 21:50
// **/
//
//
///**
// * describe: TODO  user-role
// * creat_user: hl
// * creat_date: 2018-04-02
// * creat_time: 21:51
// **/
//    @RequestMapping(value = "/userrole" , method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> getUserRoleData(Integer pageIndex, Integer pageSize) {
//        Map<String, Object> lists = userService.getSysUserRole(pageIndex,pageSize);
//        return lists;
//    }
//    @RequestMapping(value = "/userrole/add", method = RequestMethod.POST)
//    @ResponseBody
//    public XbinResult addUserRoleData(SysUser sysUser) {
//        XbinResult result = userService.saveSysUser(sysUser);
//        return result;
//    }
//    @RequestMapping(value = "/userrole/delete",method = RequestMethod.POST)
//    @ResponseBody
//    public XbinResult delUserRoleData( String IDS) {
//        String[] list=IDS.split(",");
//        XbinResult result = userService.deleteSysUserById(list);
//        return result;
//    }
}
