package cn.binux.serial;


import cn.binux.pojo.*;
import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.alibaba.fastjson.JSONObject;

import javax.naming.directory.SearchResult;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SerializationOptimizerImpl implements SerializationOptimizer {

    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<Class>();
        //这里可以把所有需要进行序列化的类进行添加
        classes.add(JSONObject.class);
        classes.add(Address.class);
        classes.add(Cart.class);
        classes.add(Comment.class);
        classes.add(Manager.class);
        classes.add(ManagerRole.class);
        classes.add(Menu.class);
        classes.add(Orders.class);
        classes.add(Product.class);
        classes.add(Role.class);
        classes.add(RoleMenu.class);
        classes.add(User.class);
        classes.add(EuiResult.class);
        classes.add(EuiTreeNode.class);
        classes.add(XbinResult.class);
        classes.add(SearchResult.class);
        return classes;
    }
}
