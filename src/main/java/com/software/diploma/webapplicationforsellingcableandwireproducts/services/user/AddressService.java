package com.software.diploma.webapplicationforsellingcableandwireproducts.services.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.Address;

public interface AddressService {
    Address getByUserId(long userId);
    void applyAddressUpdates(Address existAddress, Address updateAddress);
}
