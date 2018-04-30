package cn.binux.admin.service;

import cn.binux.pojo.Product;
import cn.binux.pojo.ProductInfo;

import java.util.List;
import java.util.Map;

public interface ProductService {

    /**
     * 通过id获取product
     *
     * @param productId
     * @return
     */
    public Product getProduct(Integer productId);

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
    public Map<String, Object> getProductList(Integer currPage, Integer pageSize);
    /**
     * 获取所有的商品
     *
     * @return
     */
    List<Product> getProductList();

    List<ProductInfo> getProductOrderInfoListBy(Integer productId);

    int deleteProductsByIds(String[] productIds);

    int updateProductStatus(Integer productId, Integer productStatus);

    int updateProductById(Product product);

    List<Product> getHostProductList(Integer hostnum);
}
