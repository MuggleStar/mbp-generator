package tests;

import com.mugglestar.Application;
import com.mugglestar.dto.OrderDto;
import com.mugglestar.entity.order.Order;
import com.mugglestar.entity.order.OrderItem;
import com.mugglestar.service.example.CrudExampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MuggleStar
 * @date 2020/10/22 0:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CrudExampleServiceTest {


    @Resource
    CrudExampleService crudExampleService;


    @Test
    public void testSaveExample() {

        OrderDto orderDto = new OrderDto();
        Order order = new Order();
        orderDto.setOrder(order);
        List<OrderItem> orderItemList = new ArrayList<>();
        orderDto.setOrderItemList(orderItemList);
        OrderItem orderItem1 = new OrderItem();
        OrderItem orderItem2 = new OrderItem();
        orderItemList.add(orderItem1);
        orderItemList.add(orderItem2);

        order.setOrderNo("MS20201022-01");
        order.setCreateTime(LocalDateTime.of(2020,10,22,10,0));
        order.setIsDelete(false);
        order.setStatus(10);
        order.setTotalAmount(439600);
        order.setOrderVersion(1);

        orderItem1.setSkuId(1);
        orderItem1.setPrice(1000);
        orderItem1.setAmount(5);

        orderItem2.setSkuId(1);
        orderItem2.setPrice(1500);
        orderItem2.setAmount(2);


        crudExampleService.saveExample(orderDto);
    }

    @Test
    public void testDeleteExample() {
        OrderDto orderDto = new OrderDto();
        Order order = new Order();
        orderDto.setOrder(order);
        List<Integer> orderIdList = new ArrayList<>();
        orderDto.setOrderIdList(orderIdList);

        order.setId(1);
        order.setOrderNo("MS20201022-05");
        orderIdList.add(2);
        orderIdList.add(3);

        crudExampleService.deleteExample(orderDto);
    }

    @Test
    public void testUpdateExample() {

    }

    @Test
    public void testSelectExample() {

    }

}
