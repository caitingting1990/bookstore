package com.ruoyi.project.system.orders.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 订单对象 orders
 * 
 * @author ruoyi
 * @date 2021-07-22
 */
public class Orders extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 下单数目(,间隔) */
    @Excel(name = "下单数目(,间隔)")
    private String bookIds;

    /** 下单价格(,间隔) */
    @Excel(name = "下单价格(,间隔)")
    private String bookPrices;

    /** 下单人 */
    @Excel(name = "下单人")
    private Long userId;

    /** 总价 */
    @Excel(name = "总价")
    private Double totalPrice;

    /** 订单状态(0正在结算，1结算成功待发货，2发货中，3发货成功) */
    @Excel(name = "订单状态(0正在结算，1结算成功待发货，2发货中，3发货成功)")
    private Long orderState;

    /** 开始结算时间（订单超出30分钟自动取消结算状态） */
    @Excel(name = "开始结算时间", readConverterExp = "订=单超出30分钟自动取消结算状态")
    private Date startTime;

    /** 订单确认时间（结算成功起算） */
    @Excel(name = "订单确认时间", readConverterExp = "结=算成功起算")
    private Date dealTime;

    /** 订单完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "订单完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 服务订单人员 */
    @Excel(name = "服务订单人员")
    private Long servicer;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setBookIds(String bookIds)
    {
        this.bookIds = bookIds;
    }

    public String getBookIds()
    {
        return bookIds;
    }
    public void setBookPrices(String bookPrices)
    {
        this.bookPrices = bookPrices;
    }

    public String getBookPrices()
    {
        return bookPrices;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setTotalPrice(Double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public Double getTotalPrice()
    {
        return totalPrice;
    }
    public void setOrderState(Long orderState)
    {
        this.orderState = orderState;
    }

    public Long getOrderState()
    {
        return orderState;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setDealTime(Date dealTime)
    {
        this.dealTime = dealTime;
    }

    public Date getDealTime()
    {
        return dealTime;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }
    public void setServicer(Long servicer)
    {
        this.servicer = servicer;
    }

    public Long getServicer()
    {
        return servicer;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bookIds", getBookIds())
            .append("bookPrices", getBookPrices())
            .append("userId", getUserId())
            .append("totalPrice", getTotalPrice())
            .append("orderState", getOrderState())
            .append("startTime", getStartTime())
            .append("dealTime", getDealTime())
            .append("endTime", getEndTime())
            .append("servicer", getServicer())
            .append("remark", getRemark())
            .toString();
    }
}
