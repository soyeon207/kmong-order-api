package com.kmong.memberorderapi.dto;

import com.kmong.memberorderapi.enumeration.ProductStatus;
import lombok.Getter;

@Getter
public class ProductsDto {
    protected Long id;
    protected String name;
    protected Integer price;
    protected ProductStatus status;
}
