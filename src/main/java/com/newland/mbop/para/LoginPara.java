package com.newland.mbop.para;

import java.io.ObjectOutputStream;
import java.io.Serializable;

public class LoginPara implements Serializable{
    public String imei = "359090010602488";
    public int isForceLogin = 1;
    public int loginType = 31;
    public String machine_system_ver = "4.4.2";
    public String machine_type = "";
    public String msisdn = "13720885009";
    public String password = "591618";
    public int platform = 0;
    public String portal_id = "101704";
    public String verifyTaskId;
    public String verify_code;

    private static final long serialVersionUID = 1;
}
