package cn.binux.admin.service.impl;

import cn.binux.admin.service.UserService;
import cn.binux.constant.Const;
import cn.binux.mapper.sys.SysUserMapper;
import cn.binux.pojo.XbinResult;
import cn.binux.pojo.sys.SysUser;
import cn.binux.pojo.sys.SysUserExample;
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
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public Map<String, Object> getSysUserList(Integer pageIndex, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageIndex, pageSize);
        SysUserExample example=new SysUserExample();
        SysUserExample.Criteria criteria=example.createCriteria();
        //criteria.();

        List<SysUser> list = sysUserMapper.selectByExample(example);
        //System.out.println(list.size());
        PageInfo<SysUser> pageInfo = new PageInfo<>(list);

        map.put("sEcho", pageIndex);
        map.put("iTotalRecords", pageInfo.getTotal());//数据总条数
        map.put("iTotalDisplayRecords", pageInfo.getTotal());//显示的条数
        map.put("aData", list);//数据集合
        return map;
    }

    @Override
    public Map<String, Object> getSysUserList(Integer pageIndex, Integer pageSize, SysUser sysUser) {
        return null;
    }

    @Override
    public List<SysUser> getSysUserByBean(SysUser sysUser) {
        return null;
    }

    @Override
    public XbinResult saveSysUser(SysUser sysUser) {

        int i=sysUserMapper.insertSelective(sysUser);
        return i>0? XbinResult.ok(sysUser.getUserId()) : XbinResult.build(400, "添加失败！");
    }

    @Override
    public  Map<String, Object> getSysUserRole(Integer pageIndex, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageIndex, pageSize);
        SysUserExample example=new SysUserExample();
        SysUserExample.Criteria criteria=example.createCriteria();
        //criteria.();
        List<SysUser> list = sysUserMapper.selectUserRoleByExample(example);
        //System.out.println(list.size());
        PageInfo<SysUser> pageInfo = new PageInfo<>(list);

        map.put("sEcho", pageIndex);
        map.put("iTotalRecords", pageInfo.getTotal());//数据总条数
        map.put("iTotalDisplayRecords", pageInfo.getTotal());//显示的条数
        map.put("aData", list);//数据集合
        return map;

    }

    @Override
    public XbinResult deleteSysUserById( String [] ids)  {
        boolean flag=true;
        Long lid=null;
        for (Object id:ids) {
            lid=Long.valueOf((String)id).longValue();
            if( lid!=null &&(sysUserMapper.deleteByPrimaryKey(lid)<0)){
               flag=false;
            }
        }
        return flag==true ? XbinResult.ok() : XbinResult.build(400, "删除失败！");
    }

    @Override
    public XbinResult updateSysUserById(SysUser sysUser) {
        int i=sysUserMapper.updateByPrimaryKeySelective(sysUser);
        return i>0?XbinResult.ok():XbinResult.build(400,"更新失败");
    }


}
