package cn.binux.admin.service;

import cn.binux.pojo.XbinResult;
import cn.binux.pojo.sys.SysRolePermission;

import java.util.List;
import java.util.Map;


/**
 * class_name: cn.binux.admin.service
 * package: RolePermService
 * describe: TODO
 * creat_user: hl
 * creat_date: 2018-04-03
 * creat_time: 8:45
 **/
public interface RolePermService {

      Map<String, Object> getSysRolePermList(Integer pageIndex, Integer pageSize);
      Map<String, Object> getSysRolePermList(Integer pageIndex, Integer pageSize, SysRolePermission role);
      List<SysRolePermission> getSysRolePermByBean(SysRolePermission role);
      XbinResult saveSysRolePerm(SysRolePermission role);
      XbinResult deleteSysRolePermById(String[] ids);
      XbinResult updateSysRolePermById(SysRolePermission sysRole);


}
