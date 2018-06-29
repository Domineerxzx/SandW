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
    public static final String SERVER_ADDRESS_OF_CHANGE_ADDRESS = "http://120.25.96.141:8080/address/save";
    //TODO 删除地址
    public static final String SERVER_ADDRESS_OF_DELETE_ADDRESS = "http://120.25.96.141:8080/address/dele";
    //TODO 获取商品类型
    public static final String SERVER_ADDRESS_OF_GET_TYPE = "http://120.25.96.141:8080/search/rangelist";
    //TODO 国家及地区
    public static final String[] COUNTRY_OR_AREA = {"中国内地"};
    //TODO 省
    public static final String[] PROVINCE = {"上海市","云南省","内蒙古自治区","北京市","吉林省","四川省","天津市",
            "宁夏回族自治区","安徽省","山东省","山西省","广东省","广西壮族自治区","新疆维吾尔自治区","江苏省",
            "江西省","河北省","河南省","浙江省","海南省","湖北省","湖南省","甘肃省","福建省","西藏自治区","贵州省","辽宁省",
            "重庆市","陕西省","青海省","黑龙江省"};
    //TODO 字母表
    public static final String[] BRAND_WORD_LIST = {"A","B","C","D","E","F","G", "H","I","J","K","L","M","N","O",
            "P","Q","R","S","T","U","V","W","X","Y","Z"};
}
