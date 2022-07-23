package com.edu.social.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 文章
 * @TableName article
 */
@TableName(value ="article")
@Data
public class Article implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    private String useraccount;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 标题
     */
    private String title;

    /**
     * 文章正文
     */
    private String content;

    /**
     * 发表日期
     */
    private Date createtime;

    /**
     * 修改日期
     */
    private Date updatetime;

    /**
     * 是否公开
     */
    private Integer ispublic;

    /**
     * 浏览量
     */
    private Integer visits;

    /**
     * 点赞数
     */
    private Integer thumbup;

    /**
     * 评论数
     */
    private Integer comment;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}