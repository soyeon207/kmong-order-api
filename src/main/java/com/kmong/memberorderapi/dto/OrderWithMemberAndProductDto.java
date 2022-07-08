package com.kmong.memberorderapi.dto;

import com.kmong.memberorderapi.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderWithMemberAndProductDto extends OrdersDto {

    protected MembersDto members;
    protected ProductsDto products;

    public static OrderWithMemberAndProductDto of (MembersDto members, ProductsDto products, Orders orders) {
        OrderWithMemberAndProductDto instance = new OrderWithMemberAndProductDto();
        instance.members = members;
        instance.products = products;
        instance.id = orders.getId();
        instance.status = orders.getStatus();
        return instance;
    }

}
