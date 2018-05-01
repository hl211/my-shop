package cn.binux.admin.service.impl;

import cn.binux.admin.service.CartService;
import cn.binux.constant.Const;
import cn.binux.mapper.CartMapper;
import cn.binux.pojo.Cart;
import cn.binux.pojo.CartExample;
import cn.binux.pojo.CartInfo;
import cn.binux.pojo.Product;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service(version = Const.E_SHOP_API_VERSION)
@Transactional
public class CartServiceImpl implements CartService {
    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
    @Autowired
    CartMapper cartMapper;

    /**
     * 通过userId获取cart的集合
     *
     * @param userId
     * @return
     */
    @Override
    public List<Cart> getCartForList(Integer userId) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return cartMapper.selectByExample(example);
    }

    /**
     * 更新 cart
     *
     * @param cart
     */
    @Override
    public void updateCart(Cart cart) {
        cartMapper.updateByPrimaryKeySelective(cart);
    }

    /**
     * 通过id得到cart
     *
     * @param cartId
     * @return
     */
    @Override
    public Cart getCart(Integer cartId) {
        return null;
    }

    /**
     * 删除一条购物车数据
     *
     * @param cartId
     */
    @Override
    public void deleteCartById(Integer cartId) {
        cartMapper.deleteByPrimaryKey(cartId);
    }

    /**
     * 清空该用户的购物车
     *
     * @param userId
     */
    @Override
    public void deleteCartByUser(Integer userId) {

    }

    /**
     * 获取该用户的 cart-product 映射集合
     *
     * @param userId
     * @return
     */
    @Override
    public Map<Cart, Product> getCartProductMap(Integer userId) {
        return null;
    }

    /**
     * 获取购物车数量
     *
     * @param userId
     * @return
     */
    @Override
    public int cartCount(Integer userId) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return cartMapper.selectByExample(example).size();
    }

    /**
     * 给购物车添加一条数据
     *
     * @param cart
     */
    @Override
    public int addCart(Cart cart) {
        return cartMapper.insertSelective(cart);
    }

    /**
     * 获取某个用户 确认购买的 cart-product 映射集合
     *
     * @param userId
     * @param cartIds
     * @return
     */
    @Override
    public Map<Cart, Product> getCartProductMap(Integer userId, String[] cartIds) {
        return null;
    }

    /**
     * 删除该用户已经下单的 购物车记录
     *
     * @param userId
     * @param cartIds
     */
    @Override
    public void deleteCartByUserCart(Integer userId, String[] cartIds) {

    }

    /**
     * 通过订单编号获取商品的ID和购买数量
     *
     * @param orderNum
     */
    @Override
    public List<Cart> getCartsByOrderNum(String orderNum) {
        return null;
    }

    @Override
    public int cartHaveShop(Integer userId, Integer productId) {
        CartExample example = new CartExample();
        CartExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andProductIdEqualTo(productId);
        return cartMapper.selectByExample(example).size();
    }

    public List<CartInfo> getCartList(Integer userId) {
        return cartMapper.selectByUid(userId);
    }
}
