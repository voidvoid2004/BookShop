package com.bookshop.backend.service.impl.user.book;

import com.bookshop.backend.mapper.BookMapper;
import com.bookshop.backend.pojo.Book;
import com.bookshop.backend.pojo.User;
import com.bookshop.backend.service.impl.utils.UserDetailsImpl;
import com.bookshop.backend.service.user.book.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RemoveServiceImpl implements RemoveService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Map<String, String> remove(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        User user = loginUser.getUser();

        int book_id = Integer.parseInt(data.get("book_id"));
        Book book = bookMapper.selectById(book_id);
        Map<String, String > map = new HashMap<>();

        if(book == null) {
            map.put("error_message", "书本不存在或已被删除");
            return map;
        }

        if(!book.getUserId().equals(user.getId())) {
         map.put("error_message", "没有权限删除该书本");
         return map;
        }

        bookMapper.deleteById(book_id);

        map.put("error_message", "success");
        return map;
    }
}
