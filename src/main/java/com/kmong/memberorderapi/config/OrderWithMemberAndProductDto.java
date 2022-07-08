package com.kmong.memberorderapi.config;

import com.kmong.memberorderapi.dto.MembersDto;
import com.kmong.memberorderapi.dto.OrdersDto;
import com.kmong.memberorderapi.dto.ProductsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderWithMemberAndProductDto extends OrdersDto {

    protected MembersDto members;
    protected ProductsDto products;

}
