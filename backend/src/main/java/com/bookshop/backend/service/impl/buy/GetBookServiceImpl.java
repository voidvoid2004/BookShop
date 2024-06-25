package com.bookshop.backend.service.impl.buy;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bookshop.backend.mapper.BookMapper;
import com.bookshop.backend.mapper.RecordMapper;
import com.bookshop.backend.pojo.Book;
import com.bookshop.backend.service.buy.GetBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class GetBookServiceImpl implements GetBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public JSONObject getBook(Integer page) {
        IPage<Book> bookIPage = new Page<>(page, 12);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        List<Book> books = bookMapper.selectPage(bookIPage, queryWrapper).getRecords();
        JSONObject resp = new JSONObject();
        List<JSONObject> items = new LinkedList<>();
        for(Book book: books) {
            JSONObject item = new JSONObject();
            item.put("id", book.getId());
            item.put("photo", book.getPhoto());
            item.put("title", book.getTitle());
            item.put("author", book.getAuthor());
            item.put("price", book.getPrice());
            item.put("count", book.getCount());
            item.put("description", book.getDescription());
            item.put("error_message", "");

            items.add(item);
        }

        resp.put("books", items);
        resp.put("books_count", bookMapper.selectCount(null));

        return resp;
    }
}
