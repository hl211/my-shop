package cn.binux;

import cn.binux.admin.service.ProductService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EShopServiceApplication.class)
public class EShopServiceApplicationTests {
    //
//   @Autowired
//   private UserService us;
//
//    @Autowired
//    private MenuService menuService;
//    @Autowired
//    private ManagerService managerService;
    @Autowired
    private ProductService productService;
//
//	@Test
//	public void contextLoads() {
//        System.out.println(us.getUserById(1).getUsername());
//    }
//
//    @Test
//    public void menuTest() {
//        //获取用户的菜单
//        System.out.println(menuService.getMenuByManagerId(1));
////        System.out.println(menuService.getMenus(1));
//        System.out.println(menuService.getMenuStr(1));
//
//        Manager m = new Manager();
//        m.setManagerName("1111");
//        m.setManagerPassword("11111111111");
//        System.out.println(managerService.addManager(m));
//    }
//
//@Test
//public void product() {
//    System.out.println(productService.getProductList(1, 8));
//    System.out.println(productService.getProductOrderInfoListBy(null));
//}
}
