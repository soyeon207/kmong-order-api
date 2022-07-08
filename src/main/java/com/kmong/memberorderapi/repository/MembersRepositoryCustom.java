package com.kmong.memberorderapi.repository;

import com.kmong.memberorderapi.entity.Members;

public interface MembersRepositoryCustom {

    Members findByIdWithOrders(Long memberId);

}
