package com.learnmybatisspringboot.generated.dao;

import com.learnmybatisspringboot.generated.entity.BookStock;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 图书库存表(BookStock)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-23 10:54:14
 */
public interface BookStockDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BookStock queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BookStock> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bookStock 实例对象
     * @return 对象列表
     */
    List<BookStock> queryAll(BookStock bookStock);

    /**
     * 新增数据
     *
     * @param bookStock 实例对象
     * @return 影响行数
     */
    int insert(BookStock bookStock);

    /**
     * 修改数据
     *
     * @param bookStock 实例对象
     * @return 影响行数
     */
    int update(BookStock bookStock);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}