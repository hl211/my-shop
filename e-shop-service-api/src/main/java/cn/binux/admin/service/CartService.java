package cn.binux.admin.service;

import cn.binux.pojo.Cart;
import cn.binux.pojo.Product;

import java.util.List;
import java.util.Map;

public interface CartService {

    /**
     * 通过userId获取cart的集合
     *
     * @param userId
     * @return
     */
    List<Cart> getCartForList(int userId);

    /**
     * 更新 cart
     *
     * @param cart
     */
    void updateCart(Cart cart);

    /**
     * 通过id得到cart
     *
     * @param cartId
     * @return
     */
    Cart getCart(int cartId);

    /**
     * 删除一条购物车数据
     *
     * @param cartId
     */
    void deleteCartById(int cartId);

    /**
     * 清空该用户的购物车
     *
     * @param userId
     */
    void deleteCartByUser(int userId);

    /**
     * 获取该用户的 cart-product 映射集合
     *
     * @param userId
     * @return
     */
    Map<Cart, Product> getCartProductMap(int userId);

    /**
     * 获取购物车数量
     *
     * @param userId
     * @return
     */
    int cartCount(int userId);

    /**
     * 给购物车添加一条数据
     *
     * @param cart
     */
    int addCart(Cart cart);


    /**
     * 获取某个用户 确认购买的 cart-product 映射集合
     *
     * @param userId
     * @param cartIds
     * @return
     */
    Map<Cart, Product> getCartProductMap(int userId, String[] cartIds);

    /**
     * 删除该用户已经下单的 购物车记录
     *
     * @param userId
     * @param cartIds
     */
    void deleteCartByUserCart(int userId, String[] cartIds);

    /**
     * 通过订单编号获取商品的ID和购买数量
     * @param orderNum
     */
    List<Cart> getCartsByOrderNum(String orderNum);
}
