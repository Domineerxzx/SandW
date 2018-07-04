package com.triplebro.aran.sandw.beans;

import java.util.List;

public class BrandInfo {


    private List<BrandListBean> brandList;

    public List<BrandListBean> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<BrandListBean> brandList) {
        this.brandList = brandList;
    }

    public static class BrandListBean {
        /**
         * classValue : {"C":["Champion"],"S":["SAM EDELMAN"]}
         * className : Man
         */

        private ClassValueBean classValue;
        private String className;

        public ClassValueBean getClassValue() {
            return classValue;
        }

        public void setClassValue(ClassValueBean classValue) {
            this.classValue = classValue;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public static class ClassValueBean {
            private List<String> C;
            private List<String> S;

            public List<String> getC() {
                return C;
            }

            public void setC(List<String> C) {
                this.C = C;
            }

            public List<String> getS() {
                return S;
            }

            public void setS(List<String> S) {
                this.S = S;
            }
        }
    }
}
