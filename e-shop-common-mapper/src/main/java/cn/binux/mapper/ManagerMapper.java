package cn.binux.mapper;

import cn.binux.pojo.Manager;
import cn.binux.pojo.ManagerExample;
import cn.binux.pojo.ManagerPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerMapper {
    int countByExample(ManagerExample example);

    int deleteByExample(ManagerExample example);

    int deleteByPrimaryKey(Integer managerId);

    int insert(Manager record);

    int insertSelective(Manager record);

    List<Manager> selectByExample(ManagerExample example);

    Manager selectByPrimaryKey(Integer managerId);

    List<ManagerPermission> selectManagerPermission();

    int updateByExampleSelective(@Param("record") Manager record, @Param("example") ManagerExample example);

    int updateByExample(@Param("record") Manager record, @Param("example") ManagerExample example);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}