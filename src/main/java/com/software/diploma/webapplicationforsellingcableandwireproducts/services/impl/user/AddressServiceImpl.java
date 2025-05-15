package com.software.diploma.webapplicationforsellingcableandwireproducts.services.impl.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.Address;
import com.software.diploma.webapplicationforsellingcableandwireproducts.repository.user.AddressRepository;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.user.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;

    @Transactional(readOnly = true)
    public Address getByUserId(long userId) {
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void applyAddressUpdates(Address existAddress, Address updateAddress) {
        if (existAddress == null) {
            existAddress = new Address();
        }

        if (updateAddress.getCountry() != null) {
            existAddress.setCountry(updateAddress.getCountry());
        }

        if (updateAddress.getRegion() != null) {
            existAddress.setRegion(updateAddress.getRegion());
        }

        if (updateAddress.getCity() != null) {
            existAddress.setCity(updateAddress.getCity());
        }

        if (updateAddress.getStreet() != null) {
            existAddress.setStreet(updateAddress.getStreet());
        }

        if (updateAddress.getHouseNumber() != null) {
            existAddress.setHouseNumber(updateAddress.getHouseNumber());
        }

        if (updateAddress.getApartmentNumber() != null) {
            existAddress.setApartmentNumber(updateAddress.getApartmentNumber());
        }

        if (updateAddress.getZipCode() != null) {
            existAddress.setZipCode(updateAddress.getZipCode());
        }

        repository.save(existAddress);
    }
}
