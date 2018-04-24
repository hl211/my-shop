package cn.binux.admin.service;

import cn.binux.pojo.Address;

import java.util.List;
import java.util.Map;

public interface AddressService {

    /**
     * 获取地址的分页信息
     *
     * @param currPage
     * @param pageSize
     * @param userId
     * @return
     */
     Map<String,Object> getAddressPager(int currPage, int pageSize, int userId);

    /**
     * 通过Id更新地址
     *
     * @param address
     */
    void updateAddressById(Address address);

    /**
     * 通过Id删除地址
     *
     * @param addressId
     */
    void deleteAddressById(int addressId);

    /**
     * 增加地址 同时返回 自增的id
     *
     * @param address
     * @return
     */
    int addAddress(Address address);

    /**
     * 通过 id 获取地址
     *
     * @param addressId
     * @return
     */
    Address getAddressById(int addressId);

    /**
     * 查询该用户的所有地址
     *
     * @param userId
     * @return
     */
    List<Address> getAddressWithUserId(int userId);
}
