package cn.binux.admin.controller;

import cn.binux.admin.service.ManagerService;
import cn.binux.admin.service.MenuService;
import cn.binux.admin.service.ProductService;
import cn.binux.admin.service.UserService;
import cn.binux.constant.Const;
import cn.binux.pojo.*;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static cn.binux.admin.util.FileUtils.saveFile;


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

    @Reference(version = Const.E_SHOP_API_VERSION)
    private ProductService productService;


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
    @RequestMapping("/User/index.html")
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

    @RequestMapping("/User/editUser.do")
    @ResponseBody
    public String editUser(User user) {
        Result result = new Result();
        int res = userService.updateUserById(user);
        if (res > 0) {
            result.setStatus("200");
            result.setText("更改成功");
        } else {
            result.setStatus("204");
            result.setText("更改失败");
        }
        return JSON.toJSONString(result);
    }

    @RequestMapping("/User/queryUsers.html")
    public String queryUsers(Model model, String username, String truename, String phone, String address) {
        List<User> users = userService.getUser(username, truename, phone, address);
        model.addAttribute("users", JSON.toJSONString(users));
        return "back/User/index";
    }

    @RequestMapping("/Product/index.html")
    public String getproduct(Model model) {
        List<ProductInfo> allproductlist = productService.getProductOrderInfoListBy();
        model.addAttribute("allproduct", JSON.toJSONString(allproductlist));
        return "back/Product/index";
    }

    @RequestMapping("/Product/deleteProduct.do")
    @ResponseBody
    public String deleteProduct(Model model, String productid) {
        Result result = new Result();
        String[] array = productid.split(",");
        if (array != null && array.length > 0) {
            if (productService.deleteProductsByIds(array) == array.length) {
                result.setStatus("200");
                result.setText("删除成功");
                return JSON.toJSONString(result);
            }
        }
        result.setStatus("204");
        result.setText("删除失败");
        return JSON.toJSONString(result);
    }

    @RequestMapping("/Product/changeProductStatus.do")
    public void changeProductStatus(Model model, Integer productStatus, Integer productId) {
        productService.updateProductStatus(productId, productStatus);
    }

    @RequestMapping("/Product/addproducts.html")
    public String toaddproducts() {
        return "back/Product/addproducts";
    }


    @RequestMapping("/Product/addProducts.do")
    // 添加商品
    public String addProducts(Model model, HttpServletRequest request,
                              HttpServletResponse response) {
        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            // 不是Multipart类型，不进行以下的操作
            return null;
        }
        List<Product> products = null;
        try {
            StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
            Map<String, String[]> formParam = req.getParameterMap();
            Iterator<String> iterator = req.getFileNames();
            products = new ArrayList<Product>();
            // 遍历items,上传文件,同时构建product对象,
            while (iterator.hasNext()) {
                MultipartFile file = req.getFile(iterator.next());
                // 对应 image1 image2 image3 image4
                String imagePath = uploadFile(file);
                Product product = buildProduct(imagePath, file.getName(),
                        formParam);
                productService.addProduct(product);
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "back/error";
        }
        model.addAttribute("products", products);
        return "back/Product/addSuccess";
    }

    @RequestMapping("/Product/editProduct.html")
    public String toeditProduct(Model model, Integer productId) {
        Product product = productService.getProduct(productId);
        model.addAttribute("product", product);
        return "back/Product/editProduct";
    }


    @RequestMapping("/Product/editProduct.do")
    // 添加商品
    public String editProducts(Model model, HttpServletRequest request,
                               HttpServletResponse response) {
        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            // 不是Multipart类型，不进行以下的操作
            return null;
        }
        List<Product> products = null;
        try {
            StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
            Map<String, String[]> formParam = req.getParameterMap();
            Iterator<String> iterator = req.getFileNames();
            products = new ArrayList<Product>();
            // 遍历items,上传文件,同时构建product对象,
            while (iterator.hasNext()) {
                MultipartFile file = req.getFile(iterator.next());
                // 对应 image1 image2 image3 image4
                String imagePath = uploadFile(file);
                Product product = buildProduct(imagePath, file.getName(),
                        formParam);
                productService.updateProductById(product);
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "back/error";
        }
        model.addAttribute("product", products.get(0));
        return "back/Product/editSuccess";
    }


    // 使用upload组件时 构建product对象
    private Product buildProduct(String imagePath, String fileFieldName,
                                 Map<String, String[]> formParam) {
        String index = fileFieldName.substring("productImagePath".length());
        String productId = null;
        if (formParam.get("productId" + index) != null) {
            productId = formParam.get("productId" + index)[0];
        }
        String productName = formParam.get("productName" + index)[0];
        String productPrice = formParam.get("productPrice" + index)[0];
        String storeNum = formParam.get("storeNum" + index)[0];
        String productStatus = formParam.get("productStatus" + index)[0];
        String productDesc = formParam.get("productDesc" + index)[0];
        // 如果能获取到productId 是修改商品调用 否则是添加商品调用
        if (productId == null) {
            return new Product(productName, Double.parseDouble(productPrice),
                    productDesc, imagePath, Integer.parseInt(storeNum),
                    Integer.parseInt(productStatus));
        } else if (imagePath == null) {
            return new Product(Integer.parseInt(productId), productName,
                    Double.parseDouble(productPrice), productDesc,
                    Integer.parseInt(storeNum), Integer.parseInt(productStatus));
        }
        return new Product(Integer.parseInt(productId), productName,
                Double.parseDouble(productPrice), productDesc, imagePath,
                Integer.parseInt(storeNum), Integer.parseInt(productStatus));
    }

    // 上传文件,同时返回image存放于web应用的路径
    private String uploadFile(MultipartFile item) {
        String imagePath = null;
        try {
            if (item.getSize() != 0) {
                String uploadFileName = item.getOriginalFilename();
                String fileName = UUID.randomUUID().toString()
                        + uploadFileName.substring(uploadFileName
                        .lastIndexOf("."));
                File path = new File(ResourceUtils.getURL("classpath:").getPath());
                File upload = new File(path.getAbsolutePath(), "static/home/upload/");
                String filePath = upload.getPath()
                        + java.io.File.separator + fileName;
                InputStream inputStream = item.getInputStream();
                saveFile(inputStream, filePath);
                System.out.println(filePath);
                imagePath = "upload/" + fileName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imagePath;
    }


    class Result {
        private String status;
        private String text;
        private Object data;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}
