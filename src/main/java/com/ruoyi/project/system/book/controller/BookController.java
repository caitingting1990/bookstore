package com.ruoyi.project.system.book.controller;

import java.util.List;

import com.ruoyi.common.constant.Global;
import com.ruoyi.framework.config.RuoYiConfig;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.book.domain.Book;
import com.ruoyi.project.system.book.service.IBookService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 图书Controller
 * 
 * @author ruoyi
 * @date 2021-07-22
 */
@Controller
@RequestMapping("/system/book")
public class BookController extends BaseController
{
    private String prefix = "system/book";

    @Autowired
    private IBookService bookService;

    @RequiresPermissions("system:book:view")
    @GetMapping()
    public String book()
    {
        return prefix + "/book";
    }

    /**
     * 添加一个图书推荐页面
     * @param mmap
     * @return
     */
    @GetMapping("/selectbooks")
    public String selectbooks(ModelMap mmap)//将该获取的对象传入到前端的载体Modelmap上
    {
        //推荐热度为60以上的书籍,调用服务层的接口selectHotBookList()，由于没有所以在接口中创建该接口,所有方法完毕
        List<Book> books= bookService.selectHotBookList(60L);
        mmap.put("hotbooks",books);
        return prefix + "/selectbooks";
    }
    /**
     * 查询图书列表
     */
    @RequiresPermissions("system:book:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Book book)
    {
        startPage();
        List<Book> list = bookService.selectBookList(book);
        return getDataTable(list);
    }

    /**
     * 导出图书列表
     */
    @RequiresPermissions("system:book:export")
    @Log(title = "图书", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Book book)
    {
        List<Book> list = bookService.selectBookList(book);
        ExcelUtil<Book> util = new ExcelUtil<Book>(Book.class);
        return util.exportExcel(list, "图书数据");
    }

    /**
     * 新增图书
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存图书
     */
    @RequiresPermissions("system:book:add")
    @Log(title = "图书", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Book book)
    {
        return toAjax(bookService.insertBook(book));
    }

    /**
     * 修改图书
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Book book = bookService.selectBookById(id);
        mmap.put("book", book);
        return prefix + "/edit";
    }

    /**
     * 修改保存图书
     */
    @RequiresPermissions("system:book:edit")
    @Log(title = "图书", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Book book)
    {
        return toAjax(bookService.updateBook(book));
    }

    /**
     * 删除图书
     */
    @RequiresPermissions("system:book:remove")
    @Log(title = "图书", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bookService.deleteBookByIds(ids));
    }
}
