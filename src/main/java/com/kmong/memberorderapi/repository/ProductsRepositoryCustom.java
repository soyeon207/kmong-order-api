package com.kmong.memberorderapi.repository;

import com.kmong.memberorderapi.dto.ProductRequest;
import com.kmong.memberorderapi.entity.Products;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductsRepositoryCustom {

    public List<Products> findProductDtoList(ProductRequest productRequest, Pageable pageable);

}
