package com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.user.UserSaveDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "userRoles", source = "roles")
    User toUser(UserSaveDto userDto);
}
