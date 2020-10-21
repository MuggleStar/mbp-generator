package com.mugglestar.service.order.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mugglestar.entity.order.OrderItem;
import com.mugglestar.mapper.order.OrderItemMapper;
import com.mugglestar.service.order.IOrderItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单明细表 服务实现类
 * </p>
 *
 * @author Madison
 * @since 2020-10-18
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {

}
