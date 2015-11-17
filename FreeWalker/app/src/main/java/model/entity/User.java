package model.entity;


import com.google.gson.annotations.Expose;

import model.common.BaseEntity;

/**
 * @author zhangyanye
 * @date 2015-8-25
 */
public class User extends BaseEntity{
    @Expose
    public int id;
    @Expose
    public String username;
    @Expose
    public String password;
    @Expose
    public String phone;
    @Expose
    public String nickname;
    @Expose
    public String school;
    @Expose
    public String gender;

}
