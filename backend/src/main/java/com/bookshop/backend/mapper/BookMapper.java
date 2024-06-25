package com.bookshop.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bookshop.backend.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
