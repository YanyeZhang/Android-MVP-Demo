package model.entity;

import com.google.gson.annotations.Expose;

import model.common.BaseEntity;

/**
 * Created by zhangyanye on 2015/8/23
 * Description: 实体类
 */
public class WebApp extends BaseEntity {
    @Expose
    public String name;
    @Expose
    public String id;
    @Expose
    public String url;
}
