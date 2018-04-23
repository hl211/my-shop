package cn.binux;

import cn.binux.admin.service.UserService;
import cn.binux.pojo.sys.SysUser;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EShopServiceApplication.class)
public class EShopServiceApplicationTests {

   @Autowired
   private UserService us;
	@Test
	public void contextLoads() {
		Map<String,Object> m=us.getSysUserList(1,4);
		System.out.println(m.get("aData"));
		System.out.println(JSON.toJSONString(m.get("aData")));
		ArrayList list=(ArrayList)m.get("aData");
		for (Object o:list){
			((SysUser)o).setUserTel("dddddddd");
		}
		System.out.println(JSON.toJSONString(m.get("aData")));
	//	System.out.println(((SysUser)((ArrayList)m.get("aData")).get(0)).getUserId());

	}

}
