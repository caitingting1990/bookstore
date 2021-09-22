package com.ruoyi.project.system.book.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 图书对象 book
 * 
 * @author ruoyi
 * @date 2021-07-22
 */
public class Book extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 图书名 */
    @Excel(name = "图书名")
    private String name;

    /** 图书价格 */
    @Excel(name = "图书价格")
    private Double price;

    /** 图书简介 */
    @Excel(name = "图书简介")
    private String detail;

    /** 图书分类 */
    @Excel(name = "图书分类")
    private String classification;

    /** 图书热度 */
    @Excel(name = "图书热度")
    private Long hot;

    /** 图书作者 */
    @Excel(name = "图书作者")
    private String author;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String imgUrl;

    /** 出版社 */
    @Excel(name = "出版社")
    private String press;

    /** 页数 */
    @Excel(name = "页数")
    private Long totalPage;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getPrice()
    {
        return price;
    }
    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public String getDetail()
    {
        return detail;
    }
    public void setClassification(String classification)
    {
        this.classification = classification;
    }

    public String getClassification()
    {
        return classification;
    }
    public void setHot(Long hot)
    {
        this.hot = hot;
    }

    public Long getHot()
    {
        return hot;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getAuthor()
    {
        return author;
    }
    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }
    public void setPress(String press)
    {
        this.press = press;
    }

    public String getPress()
    {
        return press;
    }
    public void setTotalPage(Long totalPage)
    {
        this.totalPage = totalPage;
    }

    public Long getTotalPage()
    {
        return totalPage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("price", getPrice())
            .append("detail", getDetail())
            .append("classification", getClassification())
            .append("hot", getHot())
            .append("author", getAuthor())
            .append("imgUrl", getImgUrl())
            .append("press", getPress())
            .append("totalPage", getTotalPage())
            .append("remark", getRemark())
            .toString();
    }
}
