package com.kmong.memberorderapi.service.impl;

import com.kmong.memberorderapi.dto.OrderCreateRequest;
import com.kmong.memberorderapi.dto.ResponseDto;
import com.kmong.memberorderapi.entity.Members;
import com.kmong.memberorderapi.entity.Orders;
import com.kmong.memberorderapi.entity.Products;
import com.kmong.memberorderapi.enumeration.OrderStatus;
import com.kmong.memberorderapi.mapper.OrdersWithMemberAndProductMapper;
import com.kmong.memberorderapi.repository.MembersRepository;
import com.kmong.memberorderapi.repository.OrdersRepository;
import com.kmong.memberorderapi.repository.ProductsRepository;
import com.kmong.memberorderapi.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final MembersRepository membersRepository;
    private final ProductsRepository productsRepository;
    private final OrdersRepository ordersRepository;
    private final OrdersWithMemberAndProductMapper ordersWithMemberAndProductMapper;

    @Override
    public ResponseEntity<?> createOrder(OrderCreateRequest orderCreateRequest) {

        Members members = membersRepository
                .findById(orderCreateRequest.getMemberId())
                .orElseThrow(()->new IllegalArgumentException("유저를 찾을 수 없습니다."));

        Products products = productsRepository
                .findById(orderCreateRequest.getProductId())
                .orElseThrow(()->new IllegalArgumentException("구매하려는 상품을 찾을 수 없습니다."));

        Orders orders = ordersRepository.save(Orders
                .builder()
                .members(members)
                .products(products)
                .status(OrderStatus.ORDER_COMPLETED)
                .build());

        return ResponseDto.success(ordersWithMemberAndProductMapper.toDTO(members, orders, products), "주문 생성 완료");
    }

}
