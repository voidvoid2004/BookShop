package com.bookshop.backend.service.impl.user.book;

import com.bookshop.backend.mapper.BookMapper;
import com.bookshop.backend.pojo.Book;
import com.bookshop.backend.pojo.User;
import com.bookshop.backend.service.impl.utils.UserDetailsImpl;
import com.bookshop.backend.service.user.book.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AddServiceImpl implements AddService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Map<String, String> add(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        User user = loginUser.getUser();

        String title = data.get("title");
        String author = data.get("author");
        Integer price = Integer.parseInt(data.get("price"));
        Integer count = Integer.parseInt(data.get("count"));
        String description = data.get("description");

        Map<String, String> map = new HashMap<>();

        if(title == null) {
            map.put("error_message", "书名不能为空");
            return map;
        }

        title = title.trim();
        if(title.length() == 0) {
            map.put("error_message", "书名不能为空");
            return map;
        }

        if(title.length() > 50) {
            map.put("error_message", "书名不能超过50字");
            return map;
        }

        if(author == null) {
            map.put("error_message", "作者不能为空");
            return map;
        }

        author = author.trim();
        if(author.length() == 0) {
            map.put("error_message", "作者不能为空");
            return map;
        }

        if(author.length() > 20) {
            map.put("error_message", "作者名字不能超过300字");
            return map;
        }

        if(price <= 0) {
            map.put("error_message", "价格不能为0或负数");
            return map;
        }

        if(count <= 0) {
            map.put("error_message", "数量不能为0或负数");
            return map;
        }

        if(description == null) {
            description = "这个用户很懒，什么也没留下~";
        }

        description = description.trim();
        if(description.length() == 0) {
            description = "这个用户很懒，什么也没留下~";
        }

        if(description.length() > 300) {
            map.put("error_message", "简介 不能超过20字");
            return map;
        }


        String photo = "https://cdn.acwing.com/media/user/profile/photo/245374_lg_9c7fbd3f2c.jpg";
        Date now = new Date();
        Book book = new Book(null, user.getId(), title, author, price, count,description, now, photo);
        bookMapper.insert(book);

        map.put("error_message", "success");

        return map;
    }
}
