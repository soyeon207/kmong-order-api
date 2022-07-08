package com.kmong.memberorderapi.controller;

import com.kmong.memberorderapi.dto.OrderCreateRequest;
import com.kmong.memberorderapi.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderCreateRequest orderCreateRequest) {
        return ordersService.createOrder(orderCreateRequest);
    }

}
