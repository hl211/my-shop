package cn.binux.admin.service;

import cn.binux.pojo.XbinResult;
import cn.binux.pojo.sys.SysUserRole;

import java.util.List;
import java.util.Map;



public interface UserRoleService {

      Map<String, Object> getSysRoleList(Integer pageIndex, Integer pageSize);
      Map<String, Object> getSysRoleList(Integer pageIndex, Integer pageSize, SysUserRole ur);
      List<SysUserRole> getSysRoleByBean(SysUserRole ur);
      XbinResult saveSysUserRole(SysUserRole ur);
      XbinResult deleteSysUserRoleByUid(String[] uids);
      XbinResult deleteSysUserRoleByRid(String[] rids);
      XbinResult updateSysUserRoleById(SysUserRole sysUserRole);
}
