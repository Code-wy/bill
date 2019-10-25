package com.Spring.bill.example;

import java.util.Date;

/**
*  bill_auth
* @author 王洋 2019-08-31
*/
public class Bill {
    /**
    * 账单唯一id，主键
    */
    private Integer billId;

    /**
    * 用户id，外键
    */
    private Integer userId;

    /**
    * 账单名字
    */
    private String billName;

    /**
    * 账单详情
    */
    private String billText;

    /**
    * 创建时间
    */
    private Date date;


    public Bill() {
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillText() {
        return billText;
    }

    public void setBillText(String billText) {
        this.billText = billText;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}