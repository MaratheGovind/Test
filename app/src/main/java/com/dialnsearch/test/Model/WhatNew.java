package com.dialnsearch.test.Model;

public class WhatNew {
    int originalprice,discountedprice;
    String save,name,imgurl;

    public WhatNew(){

    }

    public WhatNew(int originalprice, int discountedprice, String save, String name, String imgurl) {
        this.originalprice = originalprice;
        this.discountedprice = discountedprice;
        this.save = save;
        this.name = name;
        this.imgurl = imgurl;
    }

    public int getOriginalprice() {
        return originalprice;
    }

    public void setOriginalprice(int originalprice) {
        this.originalprice = originalprice;
    }

    public int getDiscountedprice() {
        return discountedprice;
    }

    public void setDiscountedprice(int discountedprice) {
        this.discountedprice = discountedprice;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
