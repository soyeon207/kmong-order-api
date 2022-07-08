package com.kmong.memberorderapi.dto;

import com.kmong.memberorderapi.enumeration.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDto {
    protected Long id;
    protected String name;
    protected Integer price;
    protected ProductStatus status;
}
