package com.capgemini.holecko.home_assignment.customer;

public interface CustomerService {

    /**
     * Updates CustomerDTO object if it exists otherwise exception will be thrown.
     *
     * @param customer customer
     * @return updated customer
     */

    CustomerDTO update(CustomerDTO customer);


    CustomerDTO create_TEMP_REMOVE(CustomerDTO customer);
}
