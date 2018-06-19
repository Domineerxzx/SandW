package com.triplebro.aran.sandw.properties;

public class AppProperties {
    //TODO 存放服务器访问的地址，软件内需要的常量

    public static final int UPDATE_USER_INFO_WHAT_OUTSIDE = 1;
    public static final int UPDATE_USER_INFO_WHAT_INSIDE = 2;

    //TODO 登录地址
    public static final String SERVER_ADDRESS_OF_LOGIN = "http://120.25.96.141:8080/login/loginprove";
    //TODO 注册地址
    public static final String SERVER_ADDRESS_OF_REGISTER = "http://120.25.96.141:8080//login/userRegister";
    //TODO 获取用户信息地址
    public static final String SERVER_ADDRESS_OF_SHOW_USER_INFO = "http://120.25.96.141:8080/login/userInit";
    //TODO 修改用户信息地址
    public static final String SERVER_ADDRESS_OF_CHANGE_USER_INFO = "http://120.25.96.141:8080/user/changeuserinfo";
    //TODO 修改密码地址
    public static final String SERVER_ADDRESS_OF_CHANGE_PASSWORD = "http://120.25.96.141:8080/login/changepasswd";
    //TODO 获取地址列表
    public static final String SERVER_ADDRESS_OF_SHOW_ADDRESS = "http://120.25.96.141:8080/address/list";
    //TODO 获取地址详细信息
    public static final String SERVER_ADDRESS_OF_SHOW_ADDRESS_MORE = "http://120.25.96.141:8080/address/info";
    //TODO 新增地址
    public static final String SERVER_ADDRESS_OF_ADD_ADDRESS = "http://120.25.96.141:8080/address/save";
    //TODO 修改地址
    public static final String SERVER_ADDRESS_OF_CHANGE_ADDRESS = "http://120.25.96.141:8080/login/changepasswd";
    //TODO 删除地址
    public static final String SERVER_ADDRESS_OF_DELETE_ADDRESS = "http://120.25.96.141:8080/address/dele";
}
