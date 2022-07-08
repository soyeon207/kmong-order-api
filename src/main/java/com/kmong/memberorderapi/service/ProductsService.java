package com.kmong.memberorderapi.service;

import com.kmong.memberorderapi.dto.ProductRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ProductsService {

    ResponseEntity<?> getProduct(Long productId);

    ResponseEntity<?> getProductList(ProductRequest productRequest, Pageable pageable);

}
