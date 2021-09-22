package com.ruoyi.project.system.orders.controller;

import java.util.List;

import com.ruoyi.project.system.user.domain.User;
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
import com.ruoyi.project.system.orders.domain.Orders;
import com.ruoyi.project.system.orders.service.IOrdersService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 订单Controller
 * 
 * @author ruoyi
 * @date 2021-07-22
 */
@Controller
@RequestMapping("/system/orders")
public class OrdersController extends BaseController
{
    private String prefix = "system/orders";

    @Autowired
    private IOrdersService ordersService;

    //加载订单页面
    @RequiresPermissions("system:orders:view")
    @GetMapping()
    public String orders(ModelMap mmap)//将所需信息存入到页面信息载体Modelmap中
    {
        //需要当前登录管理端的用户信息，以下方法即取得当前用户的信息了
        User user = getSysUser();
        //将该用户信息直接封装到前端
        mmap.put("user",user);
        return prefix + "/orders";
    }
    /**
     * 通过id查询某个订单
     */
    @PostMapping("/selectById")
    @ResponseBody
    public Orders selectById(Long id)
    {
        return ordersService.selectOrdersById(id);
    }


    /**
     * 查询订单列表
     */
    @RequiresPermissions("system:orders:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Orders orders)
    {
        startPage();
        List<Orders> list = ordersService.selectOrdersList(orders);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @RequiresPermissions("system:orders:export")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Orders orders)
    {
        List<Orders> list = ordersService.selectOrdersList(orders);
        ExcelUtil<Orders> util = new ExcelUtil<Orders>(Orders.class);
        return util.exportExcel(list, "订单数据");
    }

    /**
     * 新增订单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单
     */
    @RequiresPermissions("system:orders:add")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Orders orders)
    {
        return toAjax(ordersService.insertOrders(orders));
    }

    /**
     * 修改订单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Orders orders = ordersService.selectOrdersById(id);
        mmap.put("orders", orders);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单
     */
    @RequiresPermissions("system:orders:edit")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Orders orders)
    {
        return toAjax(ordersService.updateOrders(orders));
    }

    /**
     * 删除订单
     */
    @RequiresPermissions("system:orders:remove")
    @Log(title = "订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ordersService.deleteOrdersByIds(ids));
    }
}
