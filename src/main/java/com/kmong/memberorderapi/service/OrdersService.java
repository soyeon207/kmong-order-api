package com.kmong.memberorderapi.service;

import com.kmong.memberorderapi.dto.OrderCreateRequest;
import org.springframework.http.ResponseEntity;

public interface OrdersService {
    ResponseEntity<?> createOrder(OrderCreateRequest orderCreateRequest);

}
