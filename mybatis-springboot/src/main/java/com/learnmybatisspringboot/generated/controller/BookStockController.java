package com.learnmybatisspringboot.generated.controller;

import com.learnmybatisspringboot.generated.entity.BookStock;
import com.learnmybatisspringboot.generated.service.BookStockService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 图书库存表(BookStock)表控制层
 *
 * @author makejava
 * @since 2020-03-23 10:54:14
 */
@RestController
@RequestMapping("bookStock")
public class BookStockController {
    /**
     * 服务对象
     */
    @Resource
    private BookStockService bookStockService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BookStock selectOne(Long id) {
        return this.bookStockService.queryById(id);
    }

}