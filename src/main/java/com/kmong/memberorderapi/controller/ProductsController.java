package com.kmong.memberorderapi.controller;

import com.kmong.memberorderapi.dto.ProductRequest;
import com.kmong.memberorderapi.service.ProductsService;
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
    public ResponseEntity<?> getProduct(@PathVariable Long productId) {
        return productsService.getProduct(productId);
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> getProducts(
            @ModelAttribute ProductRequest productRequest,
            Pageable pageable) {
        return productsService.getProductList(productRequest, pageable);
    }

}
