package com.kmong.memberorderapi.service.impl;

import com.kmong.memberorderapi.dto.ProductRequest;
import com.kmong.memberorderapi.dto.ProductsDto;
import com.kmong.memberorderapi.dto.ResponseDto;
import com.kmong.memberorderapi.entity.Products;
import com.kmong.memberorderapi.mapper.ProductMapper;
import com.kmong.memberorderapi.repository.ProductsRepository;
import com.kmong.memberorderapi.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    private final ProductMapper productMapper;
    private final ProductsRepository productsRepository;

    @Override
    public ResponseEntity<?> getProduct(Long productId) {
        Products products = productsRepository
                .findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

        return ResponseDto.success(productMapper.toDto(products), "상품 조회 성공");
    }

    @Override
    public ResponseEntity<?> getProductList(ProductRequest productRequest, Pageable pageable) {
        List<Products> productsList = Optional
                .ofNullable(productsRepository.findProductDtoList(productRequest, pageable))
                .orElseThrow(() -> new IllegalArgumentException("조건에 맞는 상품을 찾을 수 없습니다."));

        List<ProductsDto> productsDtoList = productsList.stream().map(productMapper::toDto).collect(Collectors.toList());
        return ResponseDto.success(productsDtoList, "상품 리스트 조회 성공");
    }

}
