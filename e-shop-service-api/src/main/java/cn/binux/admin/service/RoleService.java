package cn.binux.admin.service;

import cn.binux.pojo.XbinResult;
import cn.binux.pojo.sys.SysRole;

import java.util.List;
import java.util.Map;


/**
 * class_name: cn.binux.admin.service
 * package: RoleService
 * describe: TODO
 * creat_user: hl
 * creat_date: 2018-04-02
 * creat_time: 16:59
 **/
public interface RoleService {

      Map<String, Object> getSysRoleList(Integer pageIndex, Integer pageSize);
      Map<String, Object> getSysRoleList(Integer pageIndex, Integer pageSize, SysRole sysRole);
      List<SysRole> getSysRoleByBean(SysRole sysRole);
      Map<String, Object> getSysRoleAll();
      XbinResult saveSysRole(SysRole sysRole);
      XbinResult deleteSysRoleById(String[] ids);
      XbinResult updateSysRoleById(SysRole sysRole);

      List<SysRole> getSysRoleByUserId(Integer userId);


}
