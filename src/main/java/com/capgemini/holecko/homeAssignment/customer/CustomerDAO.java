package com.capgemini.holecko.homeAssignment.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerDTO, Integer> {
}
