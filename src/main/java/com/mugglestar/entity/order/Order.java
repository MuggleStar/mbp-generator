package com.mugglestar.entity.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单表实体类
 * </p>
 *
 * @author Madison
 * @since 2020-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单状态，10：待支付；20：已支付；30：已完成；
     */
    private Integer status;

    /**
     * 是否删除，0：否；1：是；
     */
    private Boolean isDelete;

    /**
     * 下单时间
     */
    private LocalDateTime createTime;

    /**
     * 版本号
     */
    @Version
    private Integer orderVersion;

    /**
     * 订单总金额*100
     */
    private Integer totalAmount;


}
