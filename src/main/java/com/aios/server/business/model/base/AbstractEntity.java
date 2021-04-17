package com.aios.server.business.model.base;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lujianrong
 * @date 2021/4/17
 */
@Data
public abstract class AbstractEntity implements Serializable {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键编号")
    private Long id;

    @ApiModelProperty(value = "创建人编号，数据库非空")
    @TableField
    private Long createBy;

    @ApiModelProperty(value = "创建时间（数据库自动创建不需操作）")
    @TableField
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新人编号，数据库非空")
    @TableField
    private Long updateBy;

    @ApiModelProperty(value = "更新时间（数据库自动更新不需操作）")
    @TableField
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "版本号,用于乐观锁，数据库默认0")
    @TableField
    @Version
    private Integer version = 0;

    @ApiModelProperty(value = "逻辑删除是否有效（0-无效，1-有效），数据库默认1")
    @TableField
    @TableLogic(value = "1",delval = "0")
    private Integer isValid = 1;

    @ApiModelProperty(value = "备注，数据库默认空")
    @TableField
    private String remark;
}
