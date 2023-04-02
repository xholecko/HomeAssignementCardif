package com.capgemini.holecko.home_assignment.customer;

import java.util.List;

public interface CustomerService {

    /**
     * Updates Customer object if it exists otherwise exception will be thrown.
     *
     * @param updatedCustomer customer
     * @return updated customer
     */

    Customer update(Customer updatedCustomer);

    /**
     * Creates new Customer object if it not exists otherwise quotation will be updated.
     *
     * @param customer
     * @return
     */
    Customer create(Customer customer);

    /**
     * @return all customers from DB
     */
    List<Customer> findAll();

    /**
     * @param customerId customer id
     * @return customer from database with given ID, if customer does not exist exception will be thrown
     */
    Customer findById(Integer customerId);
}
