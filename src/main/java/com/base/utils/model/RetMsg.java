package com.base.utils.model;

import com.newland.mbop.para.UserInfo;

import java.io.Serializable;

public class RetMsg implements Serializable{
    public int code;
    public Object keyList;
    public String msg;
    public UserInfo obj;
    public Object objMap;
    public Integer result;

    private static final long serialVersionUID = 1;
}
