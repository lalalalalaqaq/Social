package com.edu.social.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 关注表
 * @TableName subscribe
 */
@TableName(value ="subscribe")
@Data
public class Subscribe implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 被关注用户
     */
    private String beSubuser;

    /**
     * 关注者/粉丝
     */
    private String Subuser;

    /**
     * 0:仍在关注 1:取关
     */
    @TableLogic
    private Integer isdelete;

    /**
     * 第一次建立关系的时间
     */
    private Date createtime;

    /**
     * 关系变动最新时间
     */
    private Date updatetime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}