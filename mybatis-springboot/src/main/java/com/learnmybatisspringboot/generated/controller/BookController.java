package com.learnmybatisspringboot.generated.controller;

import com.learnmybatisspringboot.generated.entity.Book;
import com.learnmybatisspringboot.generated.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Connection;

/**
 * 图书表(Book)表控制层
 *
 * @author makejava
 * @since 2020-03-23 10:53:55
 */
@RestController
@RequestMapping("book")
public class BookController {
    /**
     * 服务对象
     */
    @Resource
    private BookService bookService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Book selectOne(Long id) {
        return this.bookService.queryById(id);
    }

}