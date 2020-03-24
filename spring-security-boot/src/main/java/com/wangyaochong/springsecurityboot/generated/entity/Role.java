package com.wangyaochong.springsecurityboot.generated.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2020-03-24 08:25:01
 */
public class Role implements Serializable {
    private static final long serialVersionUID = -27868167962125802L;
    
    private Long id;
    
    private String roleName;
    
    private String description;
    
    private Date createTime;
    
    private Date updateTime;
    
    private String status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}