package com.bookshop.backend.controller.buy;

import com.bookshop.backend.service.buy.BuyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BuyBookController {
    @Autowired
    private BuyBookService buyBookService;

    @PostMapping("/buy/buybook/")
    Map<String,String > buybook(@RequestParam Map<String, String> data) {
        String book_id = data.get("book_id");
        System.out.println(book_id);
        return buyBookService.buybook(book_id);
    }
}
