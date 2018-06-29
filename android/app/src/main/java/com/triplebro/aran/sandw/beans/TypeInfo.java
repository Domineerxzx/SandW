package com.triplebro.aran.sandw.beans;

import java.util.List;

public class TypeInfo {


    private List<BigRangeListBean> bigRangeList;

    public List<BigRangeListBean> getBigRangeList() {
        return bigRangeList;
    }

    public void setBigRangeList(List<BigRangeListBean> bigRangeList) {
        this.bigRangeList = bigRangeList;
    }

    public static class BigRangeListBean {
        /**
         * bigRangeName : 包
         * itemRangeList : ["背包"]
         */

        private String bigRangeName;
        private List<String> itemRangeList;

        public String getBigRangeName() {
            return bigRangeName;
        }

        public void setBigRangeName(String bigRangeName) {
            this.bigRangeName = bigRangeName;
        }

        public List<String> getItemRangeList() {
            return itemRangeList;
        }

        public void setItemRangeList(List<String> itemRangeList) {
            this.itemRangeList = itemRangeList;
        }
    }
}
