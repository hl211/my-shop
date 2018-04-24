package cn.binux.admin.service;

import cn.binux.pojo.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    /**
     * 通过id获取product
     *
     * @param productId
     * @return
     */
    public Product getProduct(int productId);

    /**
     * 添加商品
     *
     * @param product
     */
    void addProduct(Product product);

    /**
     * 获取商品的分页信息
     *
     * @param currPage
     * @param pageSize
     * @return
     */
    public Map<String,Object> getPager(int currPage, int pageSize);
    /**
     * 获取所有的商品
     *
     * @return
     */
    List<Product> getAll();
}
