package com.ruoyi.project.system.book.service;

import java.util.List;
import com.ruoyi.project.system.book.domain.Book;

/**
 * 图书Service接口
 * 
 * @author ruoyi
 * @date 2021-07-22
 */
public interface IBookService 
{
    /**
     * 查询图书
     * 
     * @param id 图书ID
     * @return 图书
     */
    public Book selectBookById(Long id);

    /**
     * 查询图书列表
     * 
     * @param book 图书
     * @return 图书集合
     */
    public List<Book> selectBookList(Book book);

    /**
     * 新增图书
     * 
     * @param book 图书
     * @return 结果
     */
    public int insertBook(Book book);

    /**
     * 修改图书
     * 
     * @param book 图书
     * @return 结果
     */
    public int updateBook(Book book);

    /**
     * 批量删除图书
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBookByIds(String ids);

    /**
     * 删除图书信息
     * 
     * @param id 图书ID
     * @return 结果
     */
    public int deleteBookById(Long id);

    List<Book> selectHotBookList(Long hot);
}
