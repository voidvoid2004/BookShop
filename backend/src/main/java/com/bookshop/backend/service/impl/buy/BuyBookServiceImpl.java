package com.bookshop.backend.service.impl.buy;

import com.bookshop.backend.mapper.BookMapper;
import com.bookshop.backend.mapper.RecordMapper;
import com.bookshop.backend.mapper.UserMapper;
import com.bookshop.backend.pojo.Book;
import com.bookshop.backend.pojo.Record;
import com.bookshop.backend.pojo.User;
import com.bookshop.backend.service.buy.BuyBookService;
import com.bookshop.backend.service.impl.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class BuyBookServiceImpl implements BuyBookService {

    private ReentrantLock lock = new ReentrantLock();

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Map<String, String> buybook(String bookid) {

        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        Integer book_id = Integer.parseInt(bookid);

        Book book = bookMapper.selectById(book_id);
        System.out.println(book_id);
        User seller = userMapper.selectById(book.getUserId());

        System.out.println(book_id);



        Map<String, String> map = new HashMap<>();

        if(book.getUserId().equals(user.getId())) {
            map.put("error_message", "不能买自己的书");
            return map;
        }

        if(book.getCount() == 0 ) {
            map.put("error_message", "该书已经卖完！");
            return map;
        }

        if(book.getPrice() > user.getMoney()) {
            map.put("error_message", "您的余额不足！");
            return map;
        }
        lock.lock();
        try {
            int count = book.getCount();
            count --;

            int price = book.getPrice();
            int money = user.getMoney() - price;
            User new_user = new User(
                    user.getId(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getName(),
                    money,
                    user.getAddress(),
                    user.getPhoto()
            );
            userMapper.updateById(new_user);
            money = seller.getMoney() + price;

            User new_user2 = new User(
                    seller.getId(),
                    seller.getUsername(),
                    seller.getPassword(),
                    seller.getName(),
                    money,
                    seller.getAddress(),
                    seller.getPhoto()
            );

            userMapper.updateById(new_user2);

            Record new_record = new Record(
                    null,
                    user.getId(),
                    user.getName(),
                    seller.getId(),
                    seller.getName(),
                    book_id,
                    book.getTitle(),
                    price,
                    new Date()
            );
            recordMapper.insert(new_record);

            if(count != 0) {
                Book new_book = new Book(
                        book_id,
                        book.getUserId(),
                        book.getTitle(),
                        book.getAuthor(),
                        price,
                        count,
                        book.getDescription(),
                        book.getCreatetime(),
                        book.getPhoto()
                );
                bookMapper.updateById(new_book);
            } else {
                bookMapper.deleteById(book_id);
            }
        } finally {
            lock.unlock();
        }

        map.put("error_message", "success");

        return map;
    }
}
