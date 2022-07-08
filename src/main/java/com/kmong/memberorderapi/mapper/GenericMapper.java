package com.kmong.memberorderapi.mapper;

public interface GenericMapper<E, D> {
    D toDto(E e);
    E toEntity(D d);
}