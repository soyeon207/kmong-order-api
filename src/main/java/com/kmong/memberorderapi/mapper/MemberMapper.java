package com.kmong.memberorderapi.mapper;

import com.kmong.memberorderapi.dto.MembersDto;
import com.kmong.memberorderapi.entity.Members;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper extends GenericMapper<Members, MembersDto> {
}
