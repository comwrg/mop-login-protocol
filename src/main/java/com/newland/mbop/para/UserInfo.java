package com.newland.mbop.para;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;

public class UserInfo implements Serializable{
    public String agent_msisdn;
    public String homeCityId;
    public String userName;
    public String userOrgld;
    public String verifyCode;
    public String person_id;
    public PortalInfo portalInfo;
    public String msisdn;
    public ArrayList<Object> commonGroupList;
    public long currentTopMenuId;
    public String operId;
    public ArrayList<MenuInfo> MenuList;
    public ArrayList<MenuInfo> myMenuList;
    public ArrayList<SystemInfo> systemList;
    public ArrayList<MenuInfo> topToolsBarMenuList;



    private static final long serialVersionUID = 1;
}
