package com.bookshop.backend.service.impl.record;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bookshop.backend.mapper.BookMapper;
import com.bookshop.backend.mapper.RecordMapper;
import com.bookshop.backend.pojo.Book;
import com.bookshop.backend.pojo.Record;
import com.bookshop.backend.service.record.GetRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class GetRecordServiceImpl implements GetRecordService {
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public JSONObject getRecord(Integer page) {
        IPage<Record> recordIPage = new Page<>(page, 12);
        QueryWrapper<Record> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        List<Record> records = recordMapper.selectPage(recordIPage, queryWrapper).getRecords();
        JSONObject resp = new JSONObject();
        List<JSONObject> items = new LinkedList<>();
        for(Record record: records) {
            JSONObject item = new JSONObject();
            item.put("id", record.getId());
            item.put("buyername", record.getBuyerName());
            item.put("sellername", record.getSellerName());
            item.put("bookname", record.getBookName());
            item.put("price", record.getPrice());
            item.put("createtime", record.getCreatetime());
            items.add(item);
        }

        resp.put("records", items);
        resp.put("records_count", recordMapper.selectCount(null));

        return resp;
    }
}
