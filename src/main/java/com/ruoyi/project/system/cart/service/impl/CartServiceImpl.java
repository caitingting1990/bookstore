package com.ruoyi.project.system.cart.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.cart.mapper.CartMapper;
import com.ruoyi.project.system.cart.domain.Cart;
import com.ruoyi.project.system.cart.service.ICartService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 购物车Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-22
 */
@Service
public class CartServiceImpl implements ICartService 
{
    @Autowired
    private CartMapper cartMapper;

    /**
     * 查询购物车
     * 
     * @param id 购物车ID
     * @return 购物车
     */
    @Override
    public Cart selectCartById(Long id)
    {
        return cartMapper.selectCartById(id);
    }

    /**
     * 查询购物车列表
     * 
     * @param cart 购物车
     * @return 购物车
     */
    @Override
    public List<Cart> selectCartList(Cart cart)
    {
        return cartMapper.selectCartList(cart);
    }

    /**
     * 新增购物车
     * 
     * @param cart 购物车
     * @return 结果
     */
    @Override
    public int insertCart(Cart cart)
    {
        return cartMapper.insertCart(cart);
    }

    /**
     * 修改购物车
     * 
     * @param cart 购物车
     * @return 结果
     */
    @Override
    public int updateCart(Cart cart)
    {
        return cartMapper.updateCart(cart);
    }

    /**
     * 删除购物车对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCartByIds(String ids)
    {
        return cartMapper.deleteCartByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除购物车信息
     * 
     * @param id 购物车ID
     * @return 结果
     */
    @Override
    public int deleteCartById(Long id)
    {
        return cartMapper.deleteCartById(id);
    }
}
