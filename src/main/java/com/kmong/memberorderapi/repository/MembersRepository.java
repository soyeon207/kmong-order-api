package com.kmong.memberorderapi.repository;

import com.kmong.memberorderapi.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends JpaRepository<Members, Long>, MembersRepositoryCustom {
    Members findByEmail(String email);
}
