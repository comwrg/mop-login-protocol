package com.base.utils.model;

import java.io.Serializable;
import java.lang.reflect.Type;

public class HttpSendPara implements Serializable {
    public String interfaceClassName;
    public String methodName;
    public Object[] paraList;
    public Object[] parameterTypes;
    public Type returnType;

    private static final long serialVersionUID = 1;
}
