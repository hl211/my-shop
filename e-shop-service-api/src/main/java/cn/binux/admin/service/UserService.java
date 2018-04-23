package cn.binux.admin.service;

import cn.binux.pojo.XbinResult;
import cn.binux.pojo.sys.SysUser;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * class_name: cn.binx.shiro.service
     * package: ShiroService
     * describe: TODO
     * creat_user: hl
     * creat_date: 2018-03-20
     * creat_time: 15:53
     **/
      Map<String, Object> getSysUserList(Integer pageIndex, Integer pageSize);
      Map<String, Object> getSysUserList(Integer pageIndex, Integer pageSize,SysUser sysUser);
      List<SysUser> getSysUserByBean(SysUser sysUser);
      XbinResult saveSysUser(SysUser sysUser);
      XbinResult deleteSysUserById(String [] ids);
      XbinResult updateSysUserById(SysUser sysUser);

      Map<String, Object> getSysUserRole(Integer pageIndex, Integer pageSize);

}
