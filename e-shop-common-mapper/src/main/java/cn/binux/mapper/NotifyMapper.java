package cn.binux.mapper;

import cn.binux.pojo.Notify;
import cn.binux.pojo.NotifyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NotifyMapper {
//    int countByExample(NotifyExample example);

    int deleteByExample(NotifyExample example);

    int deleteByPrimaryKey(Integer NotifyId);

    int insert(Notify record);

//    int insertSelective(Notify record);

    List<Notify> selectByExample(NotifyExample example);

    Notify selectByPrimaryKey(Integer NotifyId);

    //    int updateByExampleSelective(@Param("record") Notify record, @Param("example") NotifyExample example);
//
//    int updateByExample(@Param("record") Notify record, @Param("example") NotifyExample example);
//
    int updateByPrimaryKeySelective(Notify record);
//
//    int updateByPrimaryKey(Notify record);

    int deleteProductsByIds(@Param("productIds") String[] productIds);
}