package com.mugglestar.dto;

import com.mugglestar.entity.order.Order;
import com.mugglestar.entity.order.OrderItem;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MuggleStar
 * @date 2020/10/19 0:27
 */
@Data
public class OrderDto {

    private Order order;

    private List<OrderItem> orderItemList;

    private List<Integer> orderIdList;

    private LocalDateTime createTimeStart;

    private LocalDateTime createTimeEnd;

}
