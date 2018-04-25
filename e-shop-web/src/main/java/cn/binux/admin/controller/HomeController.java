package cn.binux.admin.controller;

import cn.binux.admin.service.AddressService;
import cn.binux.admin.service.UserService;
import cn.binux.constant.Const;
import cn.binux.pojo.Address;
import cn.binux.pojo.User;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Reference(version = Const.E_SHOP_API_VERSION)
    private UserService userService;

    @Reference(version = Const.E_SHOP_API_VERSION)
    private AddressService addressService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "购物车");
        return "index";
    }

    @RequestMapping("/login.html")
    public String tologin(Model model) {
        model.addAttribute("msg", "购物车");
        return "login";
    }

    @RequestMapping("/login.do")
    @ResponseBody
    public String login(String username, String password, HttpServletRequest request) {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return "用户不存在";
        } else if (password.equals(user.getPassword())) {
            request.getSession().setAttribute("userId", user.getUserId());
            request.getSession().setAttribute("userName", user.getUsername());
            return "登陆成功";
        }
        return "密码错误";
    }

    @RequestMapping("/logout.do")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "index";
    }

    @RequestMapping("/register.html")
    public String toregisterUser() {
        return "register";
    }

    @RequestMapping("/registerUser.do")
    @ResponseBody
    public String registerUser(String username, String password, HttpServletRequest request) {
        if (userService.getUserByUsername(username) != null) {
            String str = "[{\"regStatus\":\"hasThisUser\"}]";
            return str;
        }
        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            int userId = userService.userRegister(user);
            if (userId > 0) {
                request.getSession().setAttribute("userId", userId);
                request.getSession().setAttribute("userName", user.getUsername());
                String str = "[{\"regStatus\":\"regSuccess\"}]";
                return str;
            }
        }
        return "[{\"regStatus\":\"regFail\"}]";
    }

    @RequestMapping("/account.html")
    public String myaccount() {
        return "account";
    }

    @RequestMapping("getUserById.do")
    public String getUser(Model model, HttpServletRequest request) {
        int userId = -1;
        Object object = request.getSession().getAttribute("userId");
        if (object != null) {
            userId = Integer.parseInt(object.toString());
        }
        if (userId != -1) {
            User user = userService.getUserById(userId);
            model.addAttribute("user", user);
            return "accountMsg";
        }
        return "login";
    }

    @RequestMapping("updateUserById.do")
    public String updateUser(Model model, User user, HttpServletRequest request) {
        int userId = -1;
        Object object = request.getSession().getAttribute("userId");
        if (object != null) {
            userId = Integer.parseInt(object.toString());
        }
        if (userId != -1) {
            user.setUserId(userId);
            userService.updateUserById(user);
            return getUser(model, request);
        }
        return "login";
    }

    @RequestMapping("getAddressPager.do")
    public String getAddress(Model model, HttpServletRequest request) {
        int userId = -1;
        Object object = request.getSession().getAttribute("userId");
        if (object != null) {
            userId = Integer.parseInt(object.toString());
        }
        if (userId != -1) {
            List<Address> addressList = addressService.getAddressByUserId(userId);
            if (addressList != null && addressList.size() > 0) {
                request.setAttribute("addressList", JSON.toJSONString(addressList));
            } else {
                request.setAttribute("addressList", "false");
            }
            return "accountAddress";
        }
        return "login";
    }

    @RequestMapping("deleteAddressById")
    public void deleteAddress(Integer addressId) {
        if (addressId != null) {
            addressService.deleteAddressById(addressId);
        }
    }

    @RequestMapping("editAddress.html")
    public String editAddress(Model model, Integer addressId) {
        if (addressId != null) {
            Address address = addressService.getAddressById(addressId);
            model.addAttribute("address", address);
        }
        return "accountAddEdit";
    }
}
