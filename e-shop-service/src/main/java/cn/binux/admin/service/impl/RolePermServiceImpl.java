package cn.binux.admin.service.impl;

import cn.binux.admin.service.RolePermService;
import cn.binux.constant.Const;
import cn.binux.mapper.sys.SysRolePermissionMapper;
import cn.binux.pojo.XbinResult;
import cn.binux.pojo.sys.SysRolePermission;
import cn.binux.pojo.sys.SysRolePermissionExample;
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

@Service(version = Const.XBIN_STORE_API_VERSION)
@Transactional
public class RolePermServiceImpl implements RolePermService {

    private final static Logger logger = LoggerFactory.getLogger(RolePermServiceImpl.class);

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public Map<String, Object> getSysRolePermList(Integer pageIndex, Integer pageSize) {
        pageIndex=pageIndex==null?1:pageSize;
        pageSize=pageSize==null?10:pageSize;
        PageHelper.startPage(pageIndex, pageSize);
        SysRolePermissionExample example=new SysRolePermissionExample();
        List<SysRolePermission> list = sysRolePermissionMapper.selectByExample(example);
        PageInfo<SysRolePermission> pageInfo = new PageInfo<>(list);

        Map<String, Object> map=new HashMap<String, Object>();
        map.put("sEcho", pageIndex);
        map.put("iTotalRecords", pageInfo.getTotal());//数据总条数
        map.put("iTotalDisplayRecords", pageInfo.getTotal());//显示的条数
        map.put("aData", list);//数据集合
        return map;
    }

    @Override
    public Map<String, Object> getSysRolePermList(Integer pageIndex, Integer pageSize, SysRolePermission sysRolePermission) {
        return null;
    }

    @Override
    public List<SysRolePermission> getSysRolePermByBean(SysRolePermission sysRolePermission) {
        return null;
    }

    @Override
    public XbinResult saveSysRolePerm(SysRolePermission sysRolePermission) {
        return sysRolePermissionMapper.insertSelective(sysRolePermission)>0?XbinResult.ok():XbinResult.build(400,"插入失败");
    }

    @Override
    public XbinResult deleteSysRolePermById(String[] ids) {
        boolean flag=true;
        for (String id:ids) {
            if(sysRolePermissionMapper.deleteByPrimaryKey(Integer.parseInt(id))<=0){
                flag=false;
            }
        }
        return flag==true ? XbinResult.ok() : XbinResult.build(400, "删除失败！");
    }

    @Override
    public XbinResult updateSysRolePermById(SysRolePermission sysPermission) {
        return sysRolePermissionMapper.updateByPrimaryKeySelective(sysPermission)>0?XbinResult.ok():XbinResult.build(400,"更新失败");
    }
}
