package com.bookshop.backend.service.impl.user.book;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bookshop.backend.mapper.BookMapper;
import com.bookshop.backend.pojo.Book;
import com.bookshop.backend.pojo.User;
import com.bookshop.backend.service.impl.utils.UserDetailsImpl;
import com.bookshop.backend.service.user.book.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetListServiceImpl implements GetListService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getList() {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user.getId());

        return bookMapper.selectList(queryWrapper);
    }
}
