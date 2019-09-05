package cn.binux.admin.service.impl;

import cn.binux.admin.service.NotifyService;
import cn.binux.constant.Const;
import cn.binux.mapper.NotifyMapper;
import cn.binux.pojo.Notify;
import cn.binux.pojo.NotifyExample;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service(version = Const.E_SHOP_API_VERSION)
@Transactional
public class NotifyServiceImpl implements NotifyService {
    private static final Logger logger = LoggerFactory.getLogger(NotifyServiceImpl.class);

    @Autowired
    private NotifyMapper notifyMapper;


    /**
     * 通过Id 获取
     *
     * @param notifyId
     * @return
     */
    @Override
    public Notify getNotifyById(Integer notifyId) {
        return notifyMapper.selectByPrimaryKey(notifyId);
    }

    @Override
    public List<Notify> getNotifyPager() {
        NotifyExample example = new NotifyExample();
        NotifyExample.Criteria criteria = example.createCriteria();
        return notifyMapper.selectByExample(example);
    }

    /**
     * 通过id修改
     *
     * @param notify
     */
    @Override
    public int updateNotifyById(Notify notify) {
        return notifyMapper.updateByPrimaryKeySelective(notify);
    }

    /**
     * @param currPage
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> getNotifyPager(int currPage, int pageSize) {
        return null;
    }

    /**
     * 进行模糊查询时调用的方法
     *
     * @param currPage
     * @param pageSize
     * @param notify
     * @return
     */
    @Override
    public Map<String, Object> getNotifyPager(int currPage, int pageSize, Notify notify) {
        return null;
    }

    /**
     * 修改用户
     *
     * @param notify
     */
    @Override
    public void editNotify(Notify notify) {

    }

    /**
     * 删除用户
     *
     * @param notifyId
     */
    @Override
    public void deleteNotify(int notifyId) {
        notifyMapper.deleteByPrimaryKey(notifyId);
    }

    @Override
    public int deleteNotifyByIds(String[] productIds) {

        return notifyMapper.deleteProductsByIds(productIds);
    }

    @Override
    public void addnotify(Notify notify) {
        notifyMapper.insert(notify);
    }

}
