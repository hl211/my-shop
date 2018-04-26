package cn.binux.admin.service.impl;

import cn.binux.admin.service.ProductService;
import cn.binux.constant.Const;
import cn.binux.mapper.ProductMapper;
import cn.binux.pojo.Product;
import cn.binux.pojo.ProductExample;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(version = Const.E_SHOP_API_VERSION)
@Transactional
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;

    /**
     * 通过id获取product
     *
     * @param productId
     * @return
     */
    @Override
    public Product getProduct(Integer productId) {
        return null;
    }

    /**
     * 添加商品
     *
     * @param product
     */
    @Override
    public void addProduct(Product product) {

    }

    /**
     * 获取商品的分页信息
     *
     * @param currPage
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> getProductList(Integer currPage, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(currPage, pageSize);
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        //criteria.();
        List<Product> list = productMapper.selectByExample(example);
        //System.out.println(list.size());
        PageInfo<Product> pageInfo = new PageInfo<>(list);

        map.put("currPage", currPage);
        map.put("pageCount", pageInfo.getPages());//数据总条数
        map.put("dataCount", pageInfo.getTotal());//数据总条数
        map.put("aData", list);//数据集合
        return map;
    }

    /**
     * 获取所有的商品
     *
     * @return
     */
    @Override
    public List<Product> getProductList() {
        return null;
    }
}
