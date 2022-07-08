package com.kmong.memberorderapi.repository.impl;

import com.kmong.memberorderapi.entity.Orders;
import com.kmong.memberorderapi.repository.OrdersRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class OrdersRepositoryImpl extends QuerydslRepositorySupport implements OrdersRepositoryCustom {

    public OrdersRepositoryImpl() {
        super(Orders.class);
    }

}
