package com.kmong.memberorderapi.repository.impl;

import com.kmong.memberorderapi.entity.Members;
import com.kmong.memberorderapi.repository.MembersRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class MembersRepositoryImpl extends QuerydslRepositorySupport implements MembersRepositoryCustom {

    public MembersRepositoryImpl() {
        super(Members.class);
    }

}
