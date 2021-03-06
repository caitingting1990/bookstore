package com.ruoyi.project.system.cart.controller;

import java.util.List;
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
import com.ruoyi.project.system.cart.domain.Cart;
import com.ruoyi.project.system.cart.service.ICartService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 购物车Controller
 * 
 * @author ruoyi
 * @date 2021-07-22
 */
@Controller
@RequestMapping("/system/cart")
public class CartController extends BaseController
{
    private String prefix = "system/cart";

    @Autowired
    private ICartService cartService;

    @RequiresPermissions("system:cart:view")
    @GetMapping()
    public String cart()
    {
        return prefix + "/cart";
    }

    /**
     * 查询购物车列表
     */
    @RequiresPermissions("system:cart:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Cart cart)
    {
        startPage();
        List<Cart> list = cartService.selectCartList(cart);
        return getDataTable(list);
    }

    /**
     * 导出购物车列表
     */
    @RequiresPermissions("system:cart:export")
    @Log(title = "购物车", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Cart cart)
    {
        List<Cart> list = cartService.selectCartList(cart);
        ExcelUtil<Cart> util = new ExcelUtil<Cart>(Cart.class);
        return util.exportExcel(list, "购物车数据");
    }

    /**
     * 新增购物车页面
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存购物车，这个是数据保存
     */
    @RequiresPermissions("system:cart:add")
    @Log(title = "购物车", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Cart cart)
    {
        return toAjax(cartService.insertCart(cart));
    }

    /**
     * 修改购物车
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Cart cart = cartService.selectCartById(id);
        mmap.put("cart", cart);
        return prefix + "/edit";
    }

    /**
     * 修改保存购物车
     */
    @RequiresPermissions("system:cart:edit")
    @Log(title = "购物车", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Cart cart)
    {
        return toAjax(cartService.updateCart(cart));
    }

    /**
     * 删除购物车
     */
    @RequiresPermissions("system:cart:remove")
    @Log(title = "购物车", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cartService.deleteCartByIds(ids));
    }
}
