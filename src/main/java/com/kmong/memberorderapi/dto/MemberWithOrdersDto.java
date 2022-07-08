package com.kmong.memberorderapi.dto;

import com.kmong.memberorderapi.entity.Members;
import com.kmong.memberorderapi.mapper.OrderMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberWithOrdersDto extends MembersDto {

    protected Set<OrdersDto> ordersDtoSet;

    public static MemberWithOrdersDto of(Members members, OrderMapper orderMapper) {
        MemberWithOrdersDto instance = new MemberWithOrdersDto();
        instance.ordersDtoSet = members.getOrdersSet().stream().map(orderMapper::toDto).collect(Collectors.toSet());
        instance.id = members.getId();
        instance.email = members.getEmail();
        instance.phone = members.getPhone();
        instance.userRole = members.getUserRole();
        instance.name = members.getName();
        return instance;
    }

}
