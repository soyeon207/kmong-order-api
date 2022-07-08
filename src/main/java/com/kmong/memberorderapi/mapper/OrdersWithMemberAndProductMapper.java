package com.kmong.memberorderapi.mapper;

import com.kmong.memberorderapi.config.OrderWithMemberAndProductDto;
import com.kmong.memberorderapi.entity.Members;
import com.kmong.memberorderapi.entity.Orders;
import com.kmong.memberorderapi.entity.Products;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrdersWithMemberAndProductMapper extends GenericMapper<Orders, OrderWithMemberAndProductDto> {

    OrderWithMemberAndProductDto toDTO(Members members, Orders orders, Products products);

}
