package com.learnmybatisspringboot.generated.entity;

import java.io.Serializable;

/**
 * 图书库存表(BookStock)实体类
 *
 * @author makejava
 * @since 2020-03-23 10:54:14
 */
public class BookStock implements Serializable {
    private static final long serialVersionUID = -45481022322559709L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 图书id
    */
    private Long bookId;
    /**
    * 库存
    */
    private Integer stock;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}