package com.learnmybatisspringboot.generated.service.impl;

import com.learnmybatisspringboot.generated.entity.Book;
import com.learnmybatisspringboot.generated.dao.BookDao;
import com.learnmybatisspringboot.generated.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 图书表(Book)表服务实现类
 *
 * @author makejava
 * @since 2020-03-23 10:53:55
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Book queryById(Long id) {
        return this.bookDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Book> queryAllByLimit(int offset, int limit) {
        return this.bookDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Book book) {
        return this.bookDao.insert(book);
    }

    /**
     * 修改数据
     *
     * @param book 实例对象
     * @return 实例对象
     */
    @Override
    public Book update(Book book) {
        this.bookDao.update(book);
        return this.queryById(book.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.bookDao.deleteById(id) > 0;
    }
}