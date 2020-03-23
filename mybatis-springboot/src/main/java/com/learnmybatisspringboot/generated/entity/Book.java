package com.learnmybatisspringboot.generated.entity;

import java.io.Serializable;

/**
 * 图书表(Book)实体类
 *
 * @author makejava
 * @since 2020-03-23 10:53:55
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 888785680496807856L;
    /**
    * 主键
    */
    private Long id;
    /**
    * 书名
    */
    private String bookName;
    /**
    * 价格
    */
    private Double price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}