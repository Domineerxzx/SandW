package com.triplebro.aran.sandw.beans;

public class UserInfo {

    /**
     * userInfo : {"userNum":"SandW000050","sex":null,"birthday":null,"nickname":"aaaa","userName":"aaabc"}
     * sessionProve : true
     */

    private UserInfoBean userInfo;
    private boolean sessionProve;

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public boolean isSessionProve() {
        return sessionProve;
    }

    public void setSessionProve(boolean sessionProve) {
        this.sessionProve = sessionProve;
    }

    public static class UserInfoBean {
        /**
         * userNum : SandW000050
         * sex : null
         * birthday : null
         * nickname : aaaa
         * userName : aaabc
         */

        private String userNum;
        private Object sex;
        private Object birthday;
        private String nickname;
        private String userName;

        public String getUserNum() {
            return userNum;
        }

        public void setUserNum(String userNum) {
            this.userNum = userNum;
        }

        public Object getSex() {
            return sex;
        }

        public void setSex(Object sex) {
            this.sex = sex;
        }

        public Object getBirthday() {
            return birthday;
        }

        public void setBirthday(Object birthday) {
            this.birthday = birthday;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
