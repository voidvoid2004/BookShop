package com.bookshop.backend.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bookshop.backend.mapper.UserMapper;
import com.bookshop.backend.pojo.User;
import com.bookshop.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword, String name, String address) {

        Map<String , String > map = new HashMap<>();

        if(username == null) {
            map.put("error_message", "用户名不能为空");
            return map;
        }

        username = username.trim();

        if(username.isEmpty()) {
            map.put("error_message", "用户名不能为空");
            return map;
        }

        if(username.length() < 6 || username.length() > 16) {
            map.put("error_message", "用户名必须为6-16位字母和数字组合");
            return map;
        }

        if(password == null || confirmedPassword == null) {
            map.put("error_message", "密码不能为空");
            return map;
        }

        if(password.isEmpty() || confirmedPassword.isEmpty()) {
            map.put("error_message", "密码不能为空");
            return map;
        }

        if(password.length() < 8 || password.length() > 16) {
            map.put("error_message", "密码必须为8-16位字母和数字组合");
            return map;
        }

        if(!password.equals(confirmedPassword)) {
            map.put("error_message", "两次输入的密码不一致");
            return map;
        }

        if(name == null) {
            map.put("error_message", "昵称不能为空");
            return map;
        }

        name = name.trim();

        if(name.isEmpty()) {
            map.put("error_message", "昵称不能为空");
            return map;
        }

        if(name.length() < 2 || name.length() > 10) {
            map.put("error_message", "昵称长度为2-10位");
            return map;
        }

        if(address == null) {
            map.put("error_message", "地址不能为空");
            return map;
        }

        address = address.trim();

        if(address.isEmpty()) {
            map.put("error_message", "地址不能为空");
            return map;
        }

        if(address.length() > 100) {
            map.put("error_message", "地址长度不能超过100位");
            return map;
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> users = userMapper.selectList(queryWrapper);
        if(!users.isEmpty()) {
            map.put("error_message", "用户已存在");
            return map;
        }

        String encodePassword = passwordEncoder.encode(password);
        String photo = "https://cdn.acwing.com/media/user/profile/photo/245374_lg_7962656429.jpg";
        User user = new User(null, username, encodePassword, name, 100, address, photo);
        userMapper.insert(user);


        map.put("error_message", "success");


        return map;
    }
}
