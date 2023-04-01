package com.capgemini.holecko.homeAssignment.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public CustomerDTO update(CustomerDTO customer) {
        if (customerDAO.findById(customer.getId()).isEmpty()) {
            String errorMessage = "Can not update customer. Customer does not exists, can not be updated";
            log.error(errorMessage);
            throw new CustomerException(errorMessage);
        }
        return customerDAO.save(customer);
    }

    @Override
    public CustomerDTO create_TEMP_REMOVE(CustomerDTO customer) {
        Optional<CustomerDTO> customerFromDB = customerDAO.findById(customer.getId());
        if (customerFromDB.isEmpty()) {
            return customerDAO.save(customer);
        }
        String errorMessage = "Can not create new customer. Customer with given ID already exists : " + customerFromDB.get();
        log.error(errorMessage);
        throw new CustomerException(errorMessage);
    }
}
