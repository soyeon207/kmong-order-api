package com.kmong.memberorderapi.dto;

import com.kmong.memberorderapi.enumeration.ProductStatus;
import lombok.Getter;

@Getter
public class ProductRequest {
    String name;
    Integer price;
    ProductStatus status;
}
