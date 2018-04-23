package cn.binux.admin.service.impl;

import cn.binux.admin.service.RoleService;
import cn.binux.constant.Const;
import cn.binux.mapper.sys.SysRoleMapper;
import cn.binux.pojo.XbinResult;
import cn.binux.pojo.sys.SysRole;
import cn.binux.pojo.sys.SysRoleExample;
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
public class RoleServiceImpl implements RoleService {


    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public Map<String, Object> getSysRoleList(Integer pageIndex, Integer pageSize) {
        pageIndex=pageIndex==null?1:pageSize;
        pageSize=pageSize==null?10:pageSize;
        PageHelper.startPage(pageIndex, pageSize);
        SysRoleExample example=new SysRoleExample();
        List<SysRole> list = sysRoleMapper.selectByExample(example);
        PageInfo<SysRole> pageInfo = new PageInfo<>(list);

        Map<String, Object> map=new HashMap<String, Object>();
        map.put("sEcho", pageIndex);
        map.put("iTotalRecords", pageInfo.getTotal());//数据总条数
        map.put("iTotalDisplayRecords", pageInfo.getTotal());//显示的条数
        map.put("aData", list);//数据集合
        return map;
    }

    @Override
    public Map<String, Object> getSysRoleList(Integer pageIndex, Integer pageSize, SysRole sysRole) {
        return null;
    }

    @Override
    public List<SysRole> getSysRoleByBean(SysRole sysRole) {
        return null;
    }

    @Override
    public Map<String, Object> getSysRoleAll() {

        SysRoleExample example=new SysRoleExample();
        List<SysRole> list = sysRoleMapper.selectByExample(example);
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("status","200");
        map.put("aData", list);//数据集合
        return map;
    }

    @Override
    public XbinResult saveSysRole(SysRole sysRole) {
        return sysRoleMapper.insertSelective(sysRole)>0?XbinResult.ok():XbinResult.build(400,"插入失败");
    }

    @Override
    public XbinResult deleteSysRoleById(String[] ids) {
        boolean flag=true;
        for (String id:ids) {
            if(sysRoleMapper.deleteByPrimaryKey(Integer.parseInt(id))<=0){
                flag=false;
            }
        }
        return flag==true ? XbinResult.ok() : XbinResult.build(400, "删除失败！");
    }

    @Override
    public XbinResult updateSysRoleById(SysRole sysRole) {
        return sysRoleMapper.updateByPrimaryKeySelective(sysRole)>0?XbinResult.ok():XbinResult.build(400,"更新失败");
    }

    @Override
    public List<SysRole> getSysRoleByUserId(Integer userId) {
        return sysRoleMapper.selectRoleByUserId(userId);
    }
}
