package com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.user.UserDetailsUpdateDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.UserDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDetailsMapper {
    UserDetailsMapper INSTANCE = Mappers.getMapper(UserDetailsMapper.class);

    @Mapping(target = "user.username", source = "username")
    @Mapping(target = "user.email", source = "email")
    @Mapping(target = "user.firstName", source = "firstName")
    @Mapping(target = "user.lastName", source = "lastName")
    @Mapping(target = "user.phoneNumber", source = "phoneNumber")

    @Mapping(target = "user.address.country", source = "country")
    @Mapping(target = "user.address.region", source = "region")
    @Mapping(target = "user.address.city", source = "city")
    @Mapping(target = "user.address.street", source = "street")
    @Mapping(target = "user.address.houseNumber", source = "houseNumber")
    @Mapping(target = "user.address.apartmentNumber", source = "apartmentNumber")
    @Mapping(target = "user.address.zipCode", source = "zipCode")
    UserDetails toUserDetails(UserDetailsUpdateDto userDetailsUpdateDto);
}
