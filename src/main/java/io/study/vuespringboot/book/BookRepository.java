package io.study.vuespringboot.book;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 书籍仓库信息
 *
 * @author zhaowang
 */
@Repository
public class BookRepository {
    private static final List<Book> BOOK_LIST = Lists.newArrayList(
            Book.builder().id(1L).name("java").build(),
            Book.builder().id(2L).name("javascript").build(),
            Book.builder().id(3L).name("typescript").build()
    );

    public void addOrUpdate(Book book) {
        if (book.getId() == null || book.getId() < 0) {
            book.setId(System.currentTimeMillis());
            book.setName(book.getName());
        } else {
            delete(book.getId());
        }
        BOOK_LIST.add(book);
    }

    public void delete(Long bookId) {
        BOOK_LIST.removeIf(x -> bookId.equals(x.getId()));
    }

    public Pagination<Book> getByRequest(BookRequest request) {
        List<Book> bookList = new ArrayList<>();
        if (StringUtils.isNotBlank(request.getName())) {
            bookList.addAll(BOOK_LIST.stream().filter(x -> x.getName().contains(request.getName())).collect(Collectors.toList()));
        } else {
            bookList.addAll(BOOK_LIST);
        }

        int start = (request.getPageNum() - 1) * request.getPageSize();
        int limit = start + request.getPageSize();

        return Pagination.<Book>builder()
                .totalCount(bookList.size())
                .dataList(Lists.newArrayList(bookList.subList(start, Math.min(limit, bookList.size()))))
                .build();

    }
}
