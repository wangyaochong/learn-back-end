package com.wangyaochong.business.service;

import com.wangyaochong.anno.WService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangyaochong
 * @date 2020/3/26 21:54
 */
@Slf4j
@WService
public class QueryServiceImpl implements QueryService {
    @Override
    public String query(String name) {
        log.info("in query service");
        return "query result=" + name;
    }

    @Override
    public String errorMethod(String param) {
        throw new RuntimeException("出错了");
    }
}
