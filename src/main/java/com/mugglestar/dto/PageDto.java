package com.mugglestar.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author MuggleStar
 * @date 2020/10/19 1:06
 */
@Data
public class PageDto<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 每页显示条数，默认 10
     */
    private long pageSize = 10;
    /**
     * 当前页
     */
    private long currentPage = 1;
    /**
     * 总数
     */
    private long total = 0;
    /**
     * 总页数
     */
    private long totalPage = 0;
    /**
     * 查询数据列表
     */
    private List<T> result;

    /**
     * 查询条件
     */
    private T param;

}
