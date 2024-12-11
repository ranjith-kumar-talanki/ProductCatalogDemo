package com.example.productcatalogdemo.models;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseModel {
    private Long id;
    private Date createTime;
    private Date updateTime;
    private Integer markForDelete;
}
