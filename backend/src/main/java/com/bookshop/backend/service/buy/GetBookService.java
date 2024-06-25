package com.bookshop.backend.service.buy;

import com.alibaba.fastjson.JSONObject;

public interface GetBookService {
    JSONObject getBook(Integer page);
}
