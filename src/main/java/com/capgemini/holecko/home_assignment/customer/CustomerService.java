package com.capgemini.holecko.home_assignment.customer;

import java.util.List;

public interface CustomerService {

    /**
     * Updates Customer object if it exists otherwise exception will be thrown.
     *
     * @param customer customer
     * @return updated customer
     */

    Customer update(Customer updatedCustomer);

    Customer create(Customer customer);

    List<Customer> findAll();

    Customer findById(Integer customerId);
}
