package cn.binux.admin.service;

import cn.binux.pojo.Notify;

import java.util.List;
import java.util.Map;

public interface NotifyService {

    /**
     * 通过Id 获取
     *
     * @param notifyId
     * @return
     */
    Notify getNotifyById(Integer notifyId);

    /**
     * 通过id修改
     *
     * @param Notify
     */
    int updateNotifyById(Notify notify);

    /**
     * @param currPage
     * @param pageSize
     * @return
     */
    Map<String, Object> getNotifyPager(int currPage, int pageSize);

    /**
     * 进行模糊查询时调用的方法
     *
     * @param currPage
     * @param pageSize
     * @param Notify
     * @return
     */

    Map<String, Object> getNotifyPager(int currPage, int pageSize, Notify notify);

    /**
     * 修改用户
     *
     * @param Notify
     */
    void editNotify(Notify notify);

    /**
     * 删除用户
     *
     * @param NotifyId
     */
    void deleteNotify(int notifyId);

    /**
     * 通过用户名获取用户
     *
     * @param Notifyname
     * @return
     */
//    Notify getNotifyByNotifyname(String Notifyname);
//
    List<Notify> getNotifyPager();

    int deleteNotifyByIds(String[] productIds);

    void addnotify(Notify notify);
//
//    List<Notify> getNotify(String Notifyname, String truename, String phone, String address);
}
