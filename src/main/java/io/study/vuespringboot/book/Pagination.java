package io.study.vuespringboot.book;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 分页模型体
 *
 * @author zhaowang
 */
@Builder
@Data
public class Pagination<T> {
    /**
     * 记录总数
     */
    public Integer totalCount;
    /**
     * 记录列表
     */
    public List<T> dataList;
}
