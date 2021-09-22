package com.ruoyi.project.system.cart.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 购物车对象 cart
 * 
 * @author ruoyi
 * @date 2021-07-22
 */
public class Cart extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 书目id */
    @Excel(name = "书目id")
    private Long bookId;

    /** 账户id */
    @Excel(name = "账户id")
    private Long userId;

    /** 添加时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

    /** 价格 */
    @Excel(name = "价格")
    private Double price;

    /** 数目 */
    @Excel(name = "数目")
    private Long num;

    /** 状态(0购物车，1转入结算，2转入订单) */
    @Excel(name = "状态(0购物车，1转入结算，2转入订单)")
    private Long state;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setBookId(Long bookId)
    {
        this.bookId = bookId;
    }

    public Long getBookId()
    {
        return bookId;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setAddTime(Date addTime)
    {
        this.addTime = addTime;
    }

    public Date getAddTime()
    {
        return addTime;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getPrice()
    {
        return price;
    }
    public void setNum(Long num)
    {
        this.num = num;
    }

    public Long getNum()
    {
        return num;
    }
    public void setState(Long state)
    {
        this.state = state;
    }

    public Long getState()
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bookId", getBookId())
            .append("userId", getUserId())
            .append("addTime", getAddTime())
            .append("price", getPrice())
            .append("num", getNum())
            .append("state", getState())
            .append("remark", getRemark())
            .toString();
    }
}
