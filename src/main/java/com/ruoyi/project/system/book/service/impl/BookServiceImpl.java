package com.ruoyi.project.system.book.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.book.mapper.BookMapper;
import com.ruoyi.project.system.book.domain.Book;
import com.ruoyi.project.system.book.service.IBookService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 图书Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-22
 */
@Service
public class BookServiceImpl implements IBookService 
{
    @Autowired
    private BookMapper bookMapper;

    /**
     * 查询图书
     * 
     * @param id 图书ID
     * @return 图书
     */
    @Override
    public Book selectBookById(Long id)
    {
        return bookMapper.selectBookById(id);
    }

    /**
     * 查询图书列表
     * 
     * @param book 图书
     * @return 图书
     */
    @Override
    public List<Book> selectBookList(Book book)
    {
        return bookMapper.selectBookList(book);
    }

    /**
     * 新增图书
     * 
     * @param book 图书
     * @return 结果
     */
    @Override
    public int insertBook(Book book)
    {
        return bookMapper.insertBook(book);
    }

    /**
     * 修改图书
     * 
     * @param book 图书
     * @return 结果
     */
    @Override
    public int updateBook(Book book)
    {
        return bookMapper.updateBook(book);
    }

    /**
     * 删除图书对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBookByIds(String ids)
    {
        return bookMapper.deleteBookByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除图书信息
     * 
     * @param id 图书ID
     * @return 结果
     */
    @Override
    public int deleteBookById(Long id)
    {
        return bookMapper.deleteBookById(id);
    }

    //在实现接口的文件中实现该接口
    @Override
    public List<Book> selectHotBookList(Long hot) {
        //调用数据库映射文件，方便获取数据库信息，selectHotBookList()方法没有，先在bookmapper中创建该方法
        return bookMapper.selectHotBookList(hot);
    }
}
