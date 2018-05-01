package cn.binux.admin.controller;

import cn.binux.admin.service.*;
import cn.binux.admin.util.Result;
import cn.binux.constant.Const;
import cn.binux.pojo.*;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Controller
public class HomeController {

    @Reference(version = Const.E_SHOP_API_VERSION)
    private UserService userService;

    @Reference(version = Const.E_SHOP_API_VERSION)
    private AddressService addressService;

    @Reference(version = Const.E_SHOP_API_VERSION)
    private ProductService productService;

    @Reference(version = Const.E_SHOP_API_VERSION)
    private CartService cartService;
    @Reference(version = Const.E_SHOP_API_VERSION)
    private OrderService orderService;

    @RequestMapping("/")
    public String index(Model model) {
        // 显示主页,首页商品展示
        List<Product> pager = productService.getHostProductList(6);
        model.addAttribute("productList", pager);
        return "index";
    }

    @RequestMapping("/index.html")
    public String toindex(Model model) {
        // 显示主页,首页商品展示

        return index(model);
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
        Result result = new Result();
        if (user == null) {
            result.setStatus("204");
            result.setText("用户不存在");
            return JSON.toJSONString(result);
        } else if (password.equals(user.getPassword())) {
            request.getSession().setAttribute("userId", user.getUserId());
            request.getSession().setAttribute("userName", user.getUsername());
            int cartCount = cartService.cartCount(user.getUserId());
            request.getSession().setAttribute("cartCount", cartCount);
            result.setStatus("200");
            result.setText("登陆成功");
            return JSON.toJSONString(result);
        }
        result.setStatus("204");
        result.setText("密码错误");
        return JSON.toJSONString(result);

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

    @RequestMapping("deleteAddressById.do")
    public String deleteAddress(Integer addressId, Model model, HttpServletRequest request) {
        if (addressId != null) {
            addressService.deleteAddressById(addressId);
        }
        return getAddress(model, request);
    }

    @RequestMapping("editAddress.html")
    public String editAddress(Model model, Integer addressId) {
        if (addressId != null) {
            Address address = addressService.getAddressById(addressId);
            model.addAttribute("address", address);
        }
        return "accountAddEdit";
    }


    @RequestMapping("allProduct.html")
    public String getAllProductList(Model model, Integer currPage, Integer pageSize) {
        pageSize = 8;
        if (currPage == null) {
            currPage = 1;
        }
        Map<String, Object> productList = productService.getProductList(currPage, pageSize);
        model.addAttribute("productList", productList);
        return "allProduct";
    }


    // 获取一件商品
    @RequestMapping("/getProduct.html")
    public String getProduct(Model model, HttpServletRequest request, HttpServletResponse response) {
        Integer productId = 0;
        try {
            productId = Integer.parseInt(request.getParameter("productid"));
        } catch (Exception e) {
            System.out.println("商品id获取失败");
        }

        List<ProductInfo> productlist = productService.getProductOrderInfoListBy(productId);
//        getCommentInfo(request, response);
//        Product productInfo = leoShopDao.getSingleProductInfo(productId);
//        request.setAttribute("product", productInfo);
//        index(request, response);
        model.addAttribute("product", productlist.get(0));
        //推荐和热销商品
        List<Product> pagers = productService.getHostProductList(6);
        model.addAttribute("pagers", pagers);

        //此商品是否在购物车
        int userId = -1;
        Object object = request.getSession().getAttribute("userId");
        if (object != null) {
            userId = Integer.parseInt(object.toString());
        }
        boolean hasThisProduct = false;
        int cartCount = cartService.cartHaveShop(userId, productId);
        if (cartCount > 0) {
            hasThisProduct = true;
        }
        model.addAttribute("hasThisProduct", hasThisProduct);
        return "single";
    }

    //加入购物车
    @RequestMapping("/addProductToCart.do")
    @ResponseBody
    public String addProductToCart(Integer productId, Integer saleCount, HttpServletRequest request) {
        int userId = -1;
        Object object = request.getSession().getAttribute("userId");
        if (object != null) {
            userId = Integer.parseInt(object.toString());
        }
        int res = -1;
        Result result = new Result();
        String jsonStr = "{'cartCount':'0'}";
        if (userId != -1) {
            Cart cart = new Cart();
            cart.setProductId(productId);
            cart.setUserId(userId);
            cart.setSaleCount(saleCount);
            res = cartService.addCart(cart);
            int cartCount = cartService.cartCount(userId);
            request.getSession().setAttribute("cartCount", cartCount);
            jsonStr = "{'cartCount':'" + cartCount + "'}";
        }
        if (res > 0) {
            result.setStatus("200");
            result.setText("添加成功");
            result.setData(JSON.parseObject(jsonStr));
        } else {
            result.setStatus("204");
            result.setText("添加失败");
            result.setData(JSON.parseObject(jsonStr));
        }
        return JSON.toJSONString(result);
    }

    //去购物车
    @RequestMapping("/toCart.html")
    public String ToCartPage(Model model, HttpServletRequest request) {
        int userId = -1;
        Object object = request.getSession().getAttribute("userId");
        if (object != null) {
            userId = Integer.parseInt(object.toString());
        }
        if (userId != -1) {
            List<CartInfo> cartInfos = cartService.getCartList(userId);
            if (cartInfos != null && cartInfos.size() > 0) {
                model.addAttribute("cartInfos", cartInfos);
                return "cartPage";
            }
        }
        model.addAttribute("cartInfos", "false");
        return "cartPage";
    }

    @RequestMapping("/deleteCart.do")
    public void delCart(Integer cartId, HttpServletRequest request) {
        int userId = -1;
        Object object = request.getSession().getAttribute("userId");
        if (object != null) {
            userId = Integer.parseInt(object.toString());
        }
        if (cartId == 0) {
            List<CartInfo> cartInfos = cartService.getCartList(userId);
            for (CartInfo item : cartInfos) {
                cartService.deleteCartById(item.getCartId());
            }
        } else {
            cartService.deleteCartById(cartId);
        }
        int cartCount = cartService.cartCount(userId);
        request.getSession().setAttribute("cartCount", cartCount);
    }

    @RequestMapping("/alterSaleCount.do")
    public void alterSaleCount(Integer cartId, Integer saleCount) {
        Cart cart = new Cart();
        cart.setCartId(cartId);
        cart.setSaleCount(saleCount);
        cartService.updateCart(cart);
    }

    @RequestMapping("/buyleo.do")
    public String buyshop(Model model, HttpServletRequest request) {
        int userId = -1;
        Object object = request.getSession().getAttribute("userId");
        if (object != null) {
            userId = Integer.parseInt(object.toString());
        }
        if (userId != -1) {
            //商品
            List<CartInfo> cartInfos = cartService.getCartList(userId);
            if (cartInfos != null && cartInfos.size() > 0) {
                model.addAttribute("cartInfos", cartInfos);
            }
            //地址
            List<Address> addressList = addressService.getAddressByUserId(userId);
            model.addAttribute("addressList", addressList);
        }
        return "buyleo";
    }

    @RequestMapping("/createAddress.html")
    public String toaddAddress() {
        return "createAddress";
    }

    @RequestMapping("/addAddr.do")
    public String addAddress(String sendphone, String sendman, String sendplace, Model model, HttpServletRequest request) {
        int userId = -1;
        Object object = request.getSession().getAttribute("userId");
        if (object != null) {
            userId = Integer.parseInt(object.toString());
        }
        if (userId != -1) {
            Address address = new Address();
            address.setSendMan(sendman);
            address.setSendPhone(sendphone);
            address.setSendPlace(sendplace);
            address.setUserId(userId);
            addressService.addAddress(address);
            return getAddress(model, request);
        }
        return "login";
    }

    @RequestMapping("/addAddr2.do")
    @ResponseBody
    public String addAddressincart(String sendphone, String sendman, String sendplace, Model model, HttpServletRequest request) {
        int userId = -1;
        Object object = request.getSession().getAttribute("userId");
        if (object != null) {
            userId = Integer.parseInt(object.toString());
        }
        if (userId != -1) {
            Result result = new Result();
            Address address = new Address();
            address.setSendMan(sendman);
            address.setSendPhone(sendphone);
            address.setSendPlace(sendplace);
            address.setUserId(userId);
            Integer id = addressService.addAddress(address);
            result.setData(id);
            return JSON.toJSONString(result);
        }
        return "login";
    }


    @RequestMapping("confirmOrder.do")
    public String confirmOrder(Model model, Integer addressId, HttpServletRequest request) {
        int userId = -1;
        Object object = request.getSession().getAttribute("userId");
        if (object != null) {
            userId = Integer.parseInt(object.toString());
        }
        if (userId != -1) {
            //获取地址
            Address address = addressService.getAddressById(addressId);
            //获取
            List<Cart> productList = cartService.getCartForList(userId);
            //
            Random random = new Random();
            String ran = random.nextInt(10) * 1000 + random.nextInt(10) * 100 + random.nextInt(10) * 10 + random.nextInt(10) + "";
            String orderNum = System.currentTimeMillis() + ran + userId;
            Timestamp orderTime = new Timestamp(System.currentTimeMillis());
            double totalPrice = 0;
            for (Cart cart : productList) {
                Product product = productService.getProduct(cart.getProductId());
                //
                Orders orders = new Orders();
                orders.setOrderNum(orderNum);
                orders.setOrderTime(orderTime);
                orders.setOrderStatus(2);
                orders.setNote("");
                orders.setUserId(userId);
                orders.setSendPlace(address.getSendPlace());
                orders.setSendMan(address.getSendMan());
                orders.setSendPhone(address.getSendPhone());
                orders.setProductId(product.getProductId());
                orders.setProductName(product.getProductName());
                orders.setProductPrice(product.getProductPrice());
                orders.setSaleCount(cart.getSaleCount());
                orders.setVisible(1);
                orderService.addOrders(orders);
                totalPrice += product.getProductPrice() * cart.getSaleCount();
                cartService.deleteCartById(cart.getCartId());
            }

            model.addAttribute("address", address);
            model.addAttribute("orderNum", orderNum);
            model.addAttribute("totalPrice", totalPrice);
            request.getSession().setAttribute("cartCount", 0);
            return "createOrderSuccess";
        }
        return "login";
    }

    @RequestMapping("/buyNow.do")
    public String buyNow(Model model, Integer productId, Integer number, HttpServletRequest request) {
        addProductToCart(productId, number, request);
        return buyshop(model, request);
    }

    @RequestMapping("/getOrderMsgs.do")
    public String getOrderMsgs(Model model, HttpServletRequest request) {
        int userId = -1;
        Object object = request.getSession().getAttribute("userId");
        if (object != null) {
            userId = Integer.parseInt(object.toString());
        }
        if (userId != -1) {
            //获取订单
            List<Orders> ordersList = orderService.getOrderList(userId);
            if (ordersList != null && ordersList.size() > 0) {
                Map<String, List<ProductInfo>> map = new HashMap<>();
                String ordernum;
                for (Orders order : ordersList) {
                    ProductInfo productInfo = new ProductInfo();
                    ordernum = order.getOrderNum();
                    Product p = productService.getProduct(order.getProductId());
                    productInfo.setProductImagePath(p.getProductImagePath());
                    productInfo.setProductPrice(order.getProductId());
                    productInfo.setProductName(order.getProductName());
                    productInfo.setProductPrice(order.getProductPrice());
                    productInfo.setSales(new BigDecimal(order.getSaleCount()));
                    productInfo.setProductStatus(order.getOrderStatus());
                    productInfo.setSalesAmount(order.getProductPrice() * order.getSaleCount());
                    if (map.get(ordernum) == null) {
                        List<ProductInfo> list = new ArrayList<>();
                        list.add(productInfo);
                        map.put(ordernum, list);
                    } else {
                        List<ProductInfo> list = map.get(ordernum);
                        list.add(productInfo);
                    }
                }
                System.out.println(JSON.toJSONString(map));
                model.addAttribute("orderList", JSON.toJSONString(map));
            } else {
                model.addAttribute("orderList", "false");
            }
            return "accountOrder";
        }
        return "login";

    }

}


