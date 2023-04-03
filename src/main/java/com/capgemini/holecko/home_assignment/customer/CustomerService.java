package com.capgemini.holecko.home_assignment.customer;

import java.util.List;

public interface CustomerService {

    /**
     * @param updatedCustomer updated customer
     * @param customerId      id
     * @return updated customer
     * @throws com.capgemini.holecko.home_assignment.customer.CustomerException if customer does not exist or id is not provided
     */

    Customer update(CustomerDTO updatedCustomer, Integer customerId);

    /**
     * @param newCustomer new customer
     * @return newly created customer
     */
    Customer create(CustomerDTO newCustomer);

    /**
     * @return all customers from DB
     */
    List<Customer> findAll();

    /**
     * @param customerId customer id
     * @return customer from database with given ID
     * @throws com.capgemini.holecko.home_assignment.customer.CustomerException if customer does not exist
     */
    Customer findById(Integer customerId);
}
