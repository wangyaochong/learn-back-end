package com.wangyaochong.springsecurityboot.generated.entity;

import java.io.Serializable;

/**
 * (Permission)实体类
 *
 * @author makejava
 * @since 2020-03-23 22:36:06
 */
public class Permission implements Serializable {
    private static final long serialVersionUID = -40374618943350193L;
    
    private Long id;
    
    private String code;
    
    private String description;
    
    private String url;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}