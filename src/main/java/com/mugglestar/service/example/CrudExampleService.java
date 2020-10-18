package com.mugglestar.service.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mugglestar.dto.OrderDto;
import com.mugglestar.dto.PageDto;
import com.mugglestar.entity.order.Order;
import com.mugglestar.entity.order.OrderItem;
import com.mugglestar.service.order.IOrderItemService;
import com.mugglestar.service.order.IOrderService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.omg.CORBA.ORB;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 增删改查范例
 *
 * @author MuggleStar
 * @date 2020/10/18 19:20
 */
public class CrudExampleService {


    @Resource
    IOrderService orderService;
    @Resource
    IOrderItemService orderItemService;


    /**
     * 新增范例
     *
     * @param orderDto
     */
    public void saveExample(OrderDto orderDto) {
        Order order = orderDto.getOrder();
        List<OrderItem> orderItemList = orderDto.getOrderItemList();
        boolean saveOrder = orderService.save(order);
        Assert.isTrue(saveOrder, "保存订单失败");

        for (OrderItem orderItem : orderItemList) {
            orderItem.setOrderId(order.getId());
        }

        boolean saveBatch = orderItemService.saveBatch(orderItemList);
        Assert.isTrue(saveBatch, "保存订单明细失败");

        boolean saveBatchAndSize = orderItemService.saveBatch(orderItemList, orderItemList.size());
        Assert.isTrue(saveBatchAndSize, "保存订单明细失败");

    }

    /**
     * 删除范例
     *
     * @param orderDto
     */
    public void deleteExample(OrderDto orderDto){

        Order order = orderDto.getOrder();
        List<Integer> orderIdList = orderDto.getOrderIdList();
        LocalDateTime createTimeStart = orderDto.getCreateTimeStart();
        LocalDateTime createTimeEnd = orderDto.getCreateTimeEnd();

        // 主键删除
        boolean removeById = orderService.removeById(order);

        // 主键批量删除
        boolean removeByIds = orderService.removeByIds(orderIdList);

        // 简单条件删除
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(order);
        boolean removeByQuery = orderService.remove(queryWrapper);

        // 复杂条件删除
        LambdaQueryWrapper<Order> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper
                .setEntity(order)
                .in(Order::getId, orderIdList)
                .between(Order::getCreateTime, createTimeStart, createTimeEnd)
                .gt(Order::getCreateTime, createTimeStart)
                .lt(Order::getCreateTime, createTimeEnd);
        boolean removeByLambda = orderService.remove(lambdaQueryWrapper);

    }

    /**
     * 更新范例
     *
     * @param orderDto
     */
    public void updateExample(OrderDto orderDto){

        Order order = orderDto.getOrder();
        List<Integer> orderIdList = orderDto.getOrderIdList();
        LocalDateTime createTimeStart = orderDto.getCreateTimeStart();
        LocalDateTime createTimeEnd = orderDto.getCreateTimeEnd();
        List<Order> orderList = new ArrayList<>();

        //主键更新
        boolean updateById = orderService.updateById(order);
        // 主键批量更新
        boolean updateBatchById = orderService.updateBatchById(orderList);

        // 更新
        UpdateWrapper<Order> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .setEntity(order)
                .set("is_delete",order.getIsDelete())
                .set("status",order.getStatus())
                .eq("id",order.getId());
        boolean updateByUpdate = orderService.update(updateWrapper);

        // lambda 更新
        LambdaUpdateWrapper<Order> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper
                .setEntity(order)
                .set(Order::getIsDelete,order.getIsDelete())
                .eq(Order::getId,order.getId());

        boolean updateByLambda = orderService.update(lambdaUpdateWrapper);

    }

    /**
     * 查询范例
     *
     * @param pageDto
     * @return
     */
    public PageDto<OrderDto> selectExample(PageDto<OrderDto> pageDto) {

        OrderDto orderDto = pageDto.getParam();
        Order order = orderDto.getOrder();
        List<Integer> orderIdList = orderDto.getOrderIdList();
        LocalDateTime createTimeStart = orderDto.getCreateTimeStart();
        LocalDateTime createTimeEnd = orderDto.getCreateTimeEnd();

        // 指定主键查询
        if (null == order.getId()) {
            order.setId(1);
        }
        Order orderSelectById = orderService.getById(order);

        Page<Order> page = new Page<>();
        page.setCurrent(pageDto.getCurrentPage());
        page.setPages(pageDto.getPageSize());


        // 分页-根据实体类查
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(order);
        Page<Order> pageResult1 = orderService.page(page, queryWrapper);

        // 分页复杂查询
        LambdaQueryWrapper<Order> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper
                .setEntity(order)
                .in(Order::getId, orderIdList)
                .between(Order::getCreateTime, createTimeStart, createTimeEnd)
                .gt(Order::getCreateTime, createTimeStart)
                .lt(Order::getCreateTime, createTimeEnd);
        Page<Order> pageResult2 = orderService.page(page, lambdaQueryWrapper);


        // 封装数据
        List<Order> orderList = pageResult2.getRecords();
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order currentOrder : orderList) {
            OrderDto currentOrderDto = new OrderDto();
            currentOrderDto.setOrder(currentOrder);
            orderDtoList.add(currentOrderDto);
        }

        // 查询所有，不分页
        List<Order> orderListByQuery = orderService.list(queryWrapper);
        List<Order> orderListByLambda = orderService.list(lambdaQueryWrapper);
        List<Order> orderListByIdList = orderService.listByIds(orderIdList);

        // 封装返回结果
        pageDto.setTotal(pageResult2.getTotal());
        pageDto.setPageSize(pageResult2.getSize());
        pageDto.setTotalPage(pageResult2.getPages());
        pageDto.setResult(orderDtoList);

        return pageDto;
    }


}
