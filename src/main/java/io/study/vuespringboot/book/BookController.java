package io.study.vuespringboot.book;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api("书籍")
@CrossOrigin
@RestController
@RequestMapping("book")
public class BookController {
    @Resource
    private BookRepository bookRepository;

    @PostMapping("addOrUpdate")
    public void addOrUpdateBook(@RequestBody Book book) {
        bookRepository.addOrUpdate(book);
    }

    @DeleteMapping("delete")
    public void deleteBook(@RequestParam("bookId") Long bookId){
        bookRepository.delete(bookId);
    }

    @GetMapping("getByRequest")
    public Pagination<Book> getBooks(BookRequest request) {
        return bookRepository.getByRequest(request);
    }
}
