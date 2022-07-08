package com.kmong.memberorderapi.enumeration;

import lombok.Getter;

@Getter
public enum OrderStatus {
    ORDER_COMPLETED("주문완료"), CANCELED("취소완료"), DELIVERY_READY("배송준비중"), DELIVERING("배송중"), DELIVERY_COMPLETED("배송완료");

    public final String desc;

    OrderStatus(String desc) {
        this.desc = desc;
    }

}
