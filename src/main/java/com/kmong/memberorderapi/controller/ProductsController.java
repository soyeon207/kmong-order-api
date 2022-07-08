package com.kmong.memberorderapi.controller;

import com.kmong.memberorderapi.dto.ProductRequest;
import com.kmong.memberorderapi.service.ProductsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping("/{productId}")
    @PreAuthorize("isAuthenticated()")
    @Operation(summary = "상품 조회 API")
    public ResponseEntity<?> getProduct(@PathVariable Long productId) {
        return productsService.getProduct(productId);
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    @Operation(summary = "상품 리스트 조회 API")
    public ResponseEntity<?> getProducts(
            @ModelAttribute ProductRequest productRequest,
            Pageable pageable) {
        return productsService.getProductList(productRequest, pageable);
    }

}
