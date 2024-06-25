package com.bookshop.backend.controller.record;

import com.alibaba.fastjson.JSONObject;
import com.bookshop.backend.service.record.GetRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetRecordController {
    @Autowired
    private GetRecordService getRecordService;

    @GetMapping("/record/getrecord/")
    JSONObject getBook(@RequestParam Map<String, String> data) {
        Integer page = Integer.parseInt(data.get("page"));
        return getRecordService.getRecord(page);
    }
}
