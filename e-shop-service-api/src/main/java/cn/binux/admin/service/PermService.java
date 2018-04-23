package cn.binux.admin.service;

import cn.binux.pojo.XbinResult;
import cn.binux.pojo.sys.SysPermission;

import java.util.List;
import java.util.Map;


/**
 * class_name: cn.binux.admin.service
 * package: PermService
 * describe: TODO
 * creat_user: hl
 * creat_date: 2018-04-03
 * creat_time: 8:42
 **/
public interface PermService {

      Map<String, Object> getSysPermList(Integer pageIndex, Integer pageSize);
      Map<String, Object> getSysPermList(Integer pageIndex, Integer pageSize, SysPermission sysPermission);
      List<SysPermission> getSysPermByBean(SysPermission sysPermission);
      XbinResult saveSysPerm(SysPermission sysPermission);
      XbinResult deleteSysPermById(String[] ids);
      XbinResult updateSysPermById(SysPermission sysPermission);


}
