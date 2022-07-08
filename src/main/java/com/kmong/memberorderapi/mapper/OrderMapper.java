package com.kmong.memberorderapi.mapper;

import com.kmong.memberorderapi.dto.OrdersDto;
import com.kmong.memberorderapi.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper extends GenericMapper<Orders, OrdersDto> {
}
