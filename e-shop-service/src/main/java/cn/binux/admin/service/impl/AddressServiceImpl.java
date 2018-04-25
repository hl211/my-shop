package cn.binux.admin.service.impl;

import cn.binux.admin.service.AddressService;
import cn.binux.constant.Const;
import cn.binux.mapper.AddressMapper;
import cn.binux.pojo.Address;
import cn.binux.pojo.AddressExample;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service(version = Const.E_SHOP_API_VERSION)
@Transactional
public class AddressServiceImpl implements AddressService {
    private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Autowired
    AddressMapper addressMapper;

    /**
     * 获取地址的分页信息
     *
     * @param currPage
     * @param pageSize
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> getAddressPager(Integer currPage, Integer pageSize, Integer userId) {
        return null;
    }

    /**
     * 通过Id更新地址
     *
     * @param address
     */
    @Override
    public void updateAddressById(Address address) {

    }

    /**
     * 通过Id删除地址
     *
     * @param addressId
     */
    @Override
    public void deleteAddressById(Integer addressId) {

    }

    /**
     * 增加地址 同时返回 自增的id
     *
     * @param address
     * @return
     */
    @Override
    public int addAddress(Address address) {
        return 0;
    }

    /**
     * 通过 id 获取地址
     *
     * @param addressId
     * @return
     */
    @Override
    public Address getAddressById(Integer addressId) {
        return addressMapper.selectByPrimaryKey(addressId);
    }

    /**
     * 查询该用户的所有地址
     *
     * @param userId
     * @return
     */
    @Override
    public List<Address> getAddressByUserId(Integer userId) {
        AddressExample example = new AddressExample();
        AddressExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return addressMapper.selectByExample(example);
    }
}
