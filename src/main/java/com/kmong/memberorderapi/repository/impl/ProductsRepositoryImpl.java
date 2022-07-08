package com.kmong.memberorderapi.repository.impl;

import com.kmong.memberorderapi.dto.ProductRequest;
import com.kmong.memberorderapi.entity.Products;
import com.kmong.memberorderapi.enumeration.ProductStatus;
import com.kmong.memberorderapi.repository.ProductsRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.kmong.memberorderapi.entity.QProducts.products;

public class ProductsRepositoryImpl extends QuerydslRepositorySupport implements ProductsRepositoryCustom {

    public ProductsRepositoryImpl() {
        super(Products.class);
    }

    @Override
    public List<Products> findProductDtoList(ProductRequest productRequest, Pageable pageable) {
        return from (products)
                .where(predicateStatusAndNameAndPrice(productRequest.getStatus(), productRequest.getName(), productRequest.getPrice()))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();
    }

    private Predicate predicateStatusAndNameAndPrice(ProductStatus status, String name, Integer price) {
        BooleanBuilder builder = new BooleanBuilder();

        if (status != null) {
            builder.and(products.status.eq(status));
        }

        if (name != null) {
            builder.and(products.name.eq(name));
        }

        if (price != null) {
            builder.and(products.price.eq(price));
        }

        return builder.getValue();
    }


}
