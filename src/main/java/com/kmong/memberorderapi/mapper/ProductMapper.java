package com.kmong.memberorderapi.mapper;

import com.kmong.memberorderapi.dto.ProductsDto;
import com.kmong.memberorderapi.entity.Products;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper extends GenericMapper<Products, ProductsDto> {
}
