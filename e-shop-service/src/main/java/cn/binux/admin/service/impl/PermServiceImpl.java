package cn.binux.admin.service.impl;

import cn.binux.admin.service.PermService;
import cn.binux.constant.Const;
import cn.binux.mapper.sys.SysPermissionMapper;
import cn.binux.pojo.XbinResult;
import cn.binux.pojo.sys.SysPermission;
import cn.binux.pojo.sys.SysPermissionExample;
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
public class PermServiceImpl implements PermService{

    private static final Logger logger = LoggerFactory.getLogger(PermServiceImpl.class);

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public Map<String, Object> getSysPermList(Integer pageIndex, Integer pageSize) {
        pageIndex=pageIndex==null?1:pageSize;
        pageSize=pageSize==null?10:pageSize;
        PageHelper.startPage(pageIndex, pageSize);
        SysPermissionExample example=new SysPermissionExample();
        List<SysPermission> list = sysPermissionMapper.selectByExample(example);
        PageInfo<SysPermission> pageInfo = new PageInfo<>(list);

        Map<String, Object> map=new HashMap<String, Object>();
        map.put("sEcho", pageIndex);
        map.put("iTotalRecords", pageInfo.getTotal());//数据总条数
        map.put("iTotalDisplayRecords", pageInfo.getTotal());//显示的条数
        map.put("aData", list);//数据集合
        return map;
    }

    @Override
    public Map<String, Object> getSysPermList(Integer pageIndex, Integer pageSize, SysPermission role) {
        return null;
    }

    @Override
    public List<SysPermission> getSysPermByBean(SysPermission sysPermission) {
        return null;
    }

    @Override
    public XbinResult saveSysPerm(SysPermission sysPermission) {
        return sysPermissionMapper.insertSelective(sysPermission)>0?XbinResult.ok():XbinResult.build(400,"插入失败");
    }

    @Override
    public XbinResult deleteSysPermById(String[] ids) {
        boolean flag=true;
        for (Object id:ids) {
            if(sysPermissionMapper.deleteByPrimaryKey(Long.valueOf(String.valueOf(id)).longValue())<=0){
                flag=false;
            }
        }
        return flag==true ? XbinResult.ok() : XbinResult.build(400, "删除失败！");
    }

    @Override
    public XbinResult updateSysPermById(SysPermission sysPermission) {
       return sysPermissionMapper.updateByPrimaryKeySelective(sysPermission)>0?XbinResult.ok():XbinResult.build(400,"更新失败");
    }
}
