package com.example.mail.enums;

import lombok.Data;
import lombok.Getter;


@Getter
public enum OrderStatus {

    /**
     * 取消订单*/
    CANCLE((short)0,"取消订单"),

    /**
     * 等待支付*/
    WAIT_PAY((short)1,"待支付"),

    /**
     * 支付，待发货
     * */
    WAIT_TRANSFER((short)2,"已支付，待发货"),

    /**
     * 待收货*/
    WAIT_RECEIPT((short)3,"待收货"),

    /**已收货*/
    RECEIPT((short)4,"已收货"),

    /**订单完结*/
    COMPLETE((short)5,"已完结"),

    /**待评价*/
    TO_BE_EVALUATED((short)6,"待评价"),

    /**已评价*/
    EVALUATED((short)7,"已评价"),

    /**待退款*/
    TO_BE_REFUND((short)8,"待退款"),

    /**已退款*/
    REFUND((short)9,"已退款");





    private  short orderId;

    private String orderStatus;

    private OrderStatus(short orderId,String orderStatus){
        this.orderId=orderId;
        this.orderStatus=orderStatus;
    }

}
