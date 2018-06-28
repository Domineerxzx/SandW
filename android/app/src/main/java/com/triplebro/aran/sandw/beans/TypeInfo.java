package com.triplebro.aran.sandw.beans;

import java.util.List;

public class TypeInfo {

    /**
     * bigRangeList : {"包":["背包"],"鞋子":["布鞋","凉鞋"]}
     */

    private BigRangeListBean bigRangeList;

    public BigRangeListBean getBigRangeList() {
        return bigRangeList;
    }

    public void setBigRangeList(BigRangeListBean bigRangeList) {
        this.bigRangeList = bigRangeList;
    }

    public static class BigRangeListBean {
        private List<String> 包;
        private List<String> 鞋子;

        public List<String> get包() {
            return 包;
        }

        public void set包(List<String> 包) {
            this.包 = 包;
        }

        public List<String> get鞋子() {
            return 鞋子;
        }

        public void set鞋子(List<String> 鞋子) {
            this.鞋子 = 鞋子;
        }
    }
}
