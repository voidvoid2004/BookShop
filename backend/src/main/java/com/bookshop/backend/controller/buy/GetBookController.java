package com.bookshop.backend.controller.buy;

import com.alibaba.fastjson.JSONObject;
import com.bookshop.backend.service.impl.buy.GetBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetBookController {
    @Autowired
    private GetBookServiceImpl getBookService;

    @GetMapping("/buy/getbook/")
    JSONObject getBook(@RequestParam Map<String, String> data) {
        Integer page = Integer.parseInt(data.get("page"));
        return getBookService.getBook(page);
    }

}
