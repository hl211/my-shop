package cn.binux.admin.service.impl;

import cn.binux.admin.service.OrderService;
import cn.binux.constant.Const;
import cn.binux.mapper.OrdersMapper;
import cn.binux.pojo.OrderMsg;
import cn.binux.pojo.OrderProduct;
import cn.binux.pojo.Orders;
import cn.binux.pojo.OrdersExample;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service(version = Const.E_SHOP_API_VERSION)
@Transactional
public class OrderSerivceImpl implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderSerivceImpl.class);

    @Autowired
    OrdersMapper ordersMapper;

    /**
     * 获取未删除（可见）订单的所有订单号
     *
     * @param userId
     * @return
     */
    @Override
    public Set<String> getOrderNum(Integer userId) {
        return null;
    }

    /**
     * 根据某一订单号获取其所有商品信息
     *
     * @param orderNums
     * @return
     */
    @Override
    public List<Orders> getOrderProducts(String orderNums) {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andOrderNumEqualTo(orderNums);
        return ordersMapper.selectByExample(example);
    }

    /**
     * 获取某一订单所有的信息
     *
     * @param orderNum
     * @param product
     * @return
     */
    @Override
    public OrderMsg getOrderMsg(String orderNum, List<OrderProduct> product) {
        return null;
    }

    /**
     * 获取所有的订单信息
     *
     * @param userId
     * @return
     */
    @Override
    public List<OrderMsg> getOrderMsgs(Integer userId) {
        return null;
    }

    /**
     * 添加订单
     *
     * @param order
     * @return
     */
    @Override
    public int addOrders(Orders order) {
        return 0;
    }

    /**
     * 获取订单状态
     *
     * @param orderNum
     * @return
     */
    @Override
    public int getOrderStatus(String orderNum) {
        return 0;
    }

    /**
     * 更改订单状态
     *
     * @param orderNum
     * @param status
     */
    @Override
    public void changeOrderStatus(String orderNum, Integer status) {

    }

    /**
     * 更改订单是否前台可见
     *
     * @param orderNum
     * @param status
     */
    @Override
    public void changeOrderVisible(String orderNum, Integer status) {

    }

    /**
     * 后台获取订单所有列表
     *
     * @return
     */
    @Override
    public List<Orders> getOrderList() {
        return ordersMapper.selectByOrderList();
    }

    @Override
    public void delOrder(String[] orders) {
        for (String order : orders) {
            ordersMapper.deleOrdersByOrderNum(order);
        }
    }

    ;
}
