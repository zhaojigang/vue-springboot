package io.study.vuespringboot.book;

import lombok.Data;

/**
 * book数据请求体
 *
 * @author zhaowang
 */
@Data
public class BookRequest {
    /**
     * 书籍名称：模糊查询
     */
    private String name;
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 页大小
     */
    private Integer pageSize;
}
