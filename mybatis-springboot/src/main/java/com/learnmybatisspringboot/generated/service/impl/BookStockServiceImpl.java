package com.learnmybatisspringboot.generated.service.impl;

import com.learnmybatisspringboot.generated.entity.BookStock;
import com.learnmybatisspringboot.generated.dao.BookStockDao;
import com.learnmybatisspringboot.generated.service.BookStockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 图书库存表(BookStock)表服务实现类
 *
 * @author makejava
 * @since 2020-03-23 10:54:14
 */
@Service("bookStockService")
public class BookStockServiceImpl implements BookStockService {
    @Resource
    private BookStockDao bookStockDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BookStock queryById(Long id) {
        return this.bookStockDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BookStock> queryAllByLimit(int offset, int limit) {
        return this.bookStockDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bookStock 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(BookStock bookStock) {
        return this.bookStockDao.insert(bookStock);
    }

    /**
     * 修改数据
     *
     * @param bookStock 实例对象
     * @return 实例对象
     */
    @Override
    public BookStock update(BookStock bookStock) {
        this.bookStockDao.update(bookStock);
        return this.queryById(bookStock.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.bookStockDao.deleteById(id) > 0;
    }
}