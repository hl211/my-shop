package cn.binux.mapper;

import cn.binux.pojo.Product;
import cn.binux.pojo.ProductExample;
import cn.binux.pojo.ProductInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer productId);

    List<ProductInfo> selectProductByOrder(@Param("productId") Integer productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    int deleteProductsByIds(@Param("productIds") String[] productIds);

    List<Product> selectHostProduct(@Param("hostnum") Integer hostnum);
}