package cn.binux.admin.service;

import cn.binux.pojo.OrderMsg;
import cn.binux.pojo.OrderProduct;
import cn.binux.pojo.Orders;

import java.util.List;
import java.util.Set;

public interface OrderService {
    /**
     * 获取未删除（可见）订单的所有订单号
     *
     * @param userId
     * @return
     */
    Set<String> getOrderNum(Integer userId);

    /**
     * 根据某一订单号获取其所有商品信息
     *
     * @param orderNums
     * @return
     */
    List<Orders> getOrderProducts(String orderNums);

    /**
     * 获取某一订单所有的信息
     *
     * @param orderNum
     * @param product
     * @return
     */
    OrderMsg getOrderMsg(String orderNum, List<OrderProduct> product);

    /**
     * 获取所有的订单信息
     *
     * @param
     * @param
     * @param userId
     * @return
     */
    List<OrderMsg> getOrderMsgs(Integer userId);

    /**
     * 添加订单
     *
     * @param order
     * @return
     */
    int addOrders(Orders order);

    /**
     * 获取订单状态
     *
     * @param orderNum
     * @return
     */
    int getOrderStatus(String orderNum);

    /**
     * 更改订单状态
     *
     * @param orderNum
     * @param status
     */
    void changeOrderStatus(String orderNum, Integer status);

    /**
     * 更改订单是否前台可见
     *
     * @param orderNum
     * @param status
     */
    void changeOrderVisible(String orderNum, Integer status);

    /**
     * 后台获取订单所有列表
     *
     * @return
     */
    List<Orders> getOrderList();

    void delOrder(String[] orders);
}
