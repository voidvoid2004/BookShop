package com.bookshop.backend.service.record;

import com.alibaba.fastjson.JSONObject;

public interface GetRecordService {
    JSONObject getRecord(Integer page);
}
