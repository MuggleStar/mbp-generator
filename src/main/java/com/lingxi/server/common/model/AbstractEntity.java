package com.lingxi.server.common.model;

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

    @ApiModelProperty(value = "删除标志 0.未删除 1.删除")
    @TableField
    @TableLogic(value = "0",delval = "1")
    private Integer isDelete;

}
