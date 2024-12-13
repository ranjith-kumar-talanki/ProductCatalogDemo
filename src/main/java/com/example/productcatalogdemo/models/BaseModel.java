package com.example.productcatalogdemo.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public abstract class BaseModel {
    private Long id;
    private Date createTime;
    private Date updateTime;
    private Integer markForDelete;
}
