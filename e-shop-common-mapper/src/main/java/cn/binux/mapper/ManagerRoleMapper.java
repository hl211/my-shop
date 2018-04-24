package cn.binux.mapper;

import cn.binux.pojo.ManagerRole;
import cn.binux.pojo.ManagerRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerRoleMapper {
    int countByExample(ManagerRoleExample example);

    int deleteByExample(ManagerRoleExample example);

    int deleteByPrimaryKey(Integer managerRoleId);

    int insert(ManagerRole record);

    int insertSelective(ManagerRole record);

    List<ManagerRole> selectByExample(ManagerRoleExample example);

    ManagerRole selectByPrimaryKey(Integer managerRoleId);

    int updateByExampleSelective(@Param("record") ManagerRole record, @Param("example") ManagerRoleExample example);

    int updateByExample(@Param("record") ManagerRole record, @Param("example") ManagerRoleExample example);

    int updateByPrimaryKeySelective(ManagerRole record);

    int updateByPrimaryKey(ManagerRole record);
}