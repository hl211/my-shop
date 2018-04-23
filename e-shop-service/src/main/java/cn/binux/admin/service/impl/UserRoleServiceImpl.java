package cn.binux.admin.service.impl;

import cn.binux.admin.service.UserRoleService;
import cn.binux.constant.Const;
import cn.binux.mapper.sys.SysUserRoleMapper;
import cn.binux.pojo.XbinResult;
import cn.binux.pojo.sys.SysUserRole;
import cn.binux.pojo.sys.SysUserRoleExample;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service(version = Const.XBIN_STORE_API_VERSION)
@Transactional
public class UserRoleServiceImpl implements UserRoleService{

    private static final Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Override
    public Map<String, Object> getSysRoleList(Integer pageIndex, Integer pageSize) {
        return null;
    }

    @Override
    public Map<String, Object> getSysRoleList(Integer pageIndex, Integer pageSize, SysUserRole ur) {
        return null;
    }

    @Override
    public List<SysUserRole> getSysRoleByBean(SysUserRole ur) {
        return null;
    }

    @Override
    public XbinResult saveSysUserRole(SysUserRole ur) {
        return sysUserRoleMapper.insertSelective(ur)>0?XbinResult.ok():XbinResult.build(400,"插入失败");
    }

    @Override
    public XbinResult deleteSysUserRoleByUid(String[] uids) {
        boolean flag=true;
        for (String id:uids) {
            SysUserRoleExample sysUserRoleExample=new SysUserRoleExample();
            SysUserRoleExample.Criteria criteria=sysUserRoleExample.createCriteria();
            criteria.andUserIdEqualTo(Long.valueOf(id));
            if(sysUserRoleMapper.deleteByExample(sysUserRoleExample)<=0){
                flag=false;
            }
        }
        return flag==true ? XbinResult.ok() : XbinResult.build(400, "更新失败！");
    }

    @Override
    public XbinResult deleteSysUserRoleByRid(String[] rids) {
        return null;
    }

    @Override
    public XbinResult updateSysUserRoleById(SysUserRole sysUserRole) {
        return  sysUserRoleMapper.updateByPrimaryKeySelective(sysUserRole)>0?XbinResult.ok():XbinResult.build(400,"更新失败");
    }


}
