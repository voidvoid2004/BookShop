package com.bookshop.backend.controller.user.book;

import com.bookshop.backend.pojo.Book;
import com.bookshop.backend.service.user.book.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetListController {
    @Autowired
    private GetListService getListService;

    @GetMapping("/user/book/getlist")
    public List<Book> getlist() {
        return getListService.getList();
    }
}
