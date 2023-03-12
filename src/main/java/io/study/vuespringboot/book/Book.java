package io.study.vuespringboot.book;

import lombok.Builder;
import lombok.Data;

/**
 * 书籍模型
 *
 * @author zhaowang
 */
@Builder
@Data
public class Book {
    private Long id;
    private String name;
}
