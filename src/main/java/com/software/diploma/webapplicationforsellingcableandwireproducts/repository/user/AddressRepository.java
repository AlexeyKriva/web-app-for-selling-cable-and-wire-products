package com.software.diploma.webapplicationforsellingcableandwireproducts.repository.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
