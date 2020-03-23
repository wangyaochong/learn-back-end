package com.learnmybatisspringboot.generated.service;

import com.learnmybatisspringboot.generated.entity.Book;
import java.util.List;

/**
 * 图书表(Book)表服务接口
 *
 * @author makejava
 * @since 2020-03-23 10:53:55
 */
public interface BookService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Book queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Book> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    int insert(Book book);

    /**
     * 修改数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    Book update(Book book);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}