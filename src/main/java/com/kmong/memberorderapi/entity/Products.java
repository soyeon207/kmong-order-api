package com.kmong.memberorderapi.entity;

import com.kmong.memberorderapi.enumeration.ProductStatus;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Products extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="price", nullable = false)
    private Integer price;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private ProductStatus status;

}
