package com.kmong.memberorderapi.repository.impl;

import com.kmong.memberorderapi.entity.Members;
import com.kmong.memberorderapi.repository.MembersRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import static com.kmong.memberorderapi.entity.QMembers.members;
import static com.kmong.memberorderapi.entity.QOrders.orders;

public class MembersRepositoryImpl extends QuerydslRepositorySupport implements MembersRepositoryCustom {

    public MembersRepositoryImpl() {
        super(Members.class);
    }

    @Override
    public Members findByIdWithOrders(Long memberId) {
        return from (members)
                .leftJoin(members.ordersSet, orders).fetchJoin()
                .where(members.id.eq(memberId))
                .fetchFirst();
    }
}
