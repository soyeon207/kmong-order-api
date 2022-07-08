package com.kmong.memberorderapi.dto;

import com.kmong.memberorderapi.enumeration.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDto {

    protected Long id;
    protected OrderStatus status;

}
