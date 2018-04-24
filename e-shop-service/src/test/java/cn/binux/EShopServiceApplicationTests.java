package cn.binux;

import cn.binux.admin.service.MenuService;
import cn.binux.admin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EShopServiceApplication.class)
public class EShopServiceApplicationTests {

   @Autowired
   private UserService us;

    @Autowired
    private MenuService menuService;
	@Test
	public void contextLoads() {
        System.out.println(us.getUserById(1).getUsername());
    }

    @Test
    public void menuTest() {
        //获取用户的菜单
        System.out.println(menuService.getMenuByManagerId(1));
//        System.out.println(menuService.getMenus(1));
        System.out.println(menuService.getMenuStr(1));
    }
}
