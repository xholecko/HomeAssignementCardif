package com.capgemini.holecko.home_assignment.customer;

import com.capgemini.holecko.home_assignment.utils.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class CustomerServiceImpl implements CustomerService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public CustomerDTOResponse update(
            CustomerDTO updatedCustomer,
            Integer customerId) {
        if (customerId == null) {
            String errorMessage = "Can not update customer. Customer Id was not provided.";
            log.error(errorMessage);
            throw new CustomerException(errorMessage);
        }
        if (customerDAO.findById(customerId).isEmpty()) {
            String errorMessage = "Can not update customer. Customer does not exists, can not be updated.";
            log.error(errorMessage);
            throw new CustomerException(errorMessage);
        }
        Customer result = customerDAO.save(CustomerMapper.toEntity().apply(new Pair<>(customerId, updatedCustomer)));
        log.info("Customer successfully updated. {}", result);
        return CustomerMapper.toResponseDTO().apply(result);
    }

    @Override
    public CustomerDTOResponse create(CustomerDTO newCustomer) {
        Customer result = customerDAO.save(CustomerMapper.toEntity().apply(new Pair<>(null, newCustomer)));
        log.info("Creation of new customer is successful. {}", result);
        return CustomerMapper.toResponseDTO().apply(result);
    }

    @Override
    public List<CustomerDTOResponse> findAll() {
        return customerDAO
                .findAll()
                .stream()
                .map(customer -> CustomerMapper.toResponseDTO().apply(customer))
                .toList();
    }

    @Override
    public CustomerDTOResponse findById(Integer customerId) {
        Optional<Customer> customer = customerDAO.findById(customerId);
        if (customer.isEmpty()) {
            String errorMessage = "Can not find new customer. Customer with given ID does not exists.";
            log.error(errorMessage);
            throw new CustomerException(errorMessage);
        }
        log.info("Find customer by id is successful. {}", customer.get());
        return CustomerMapper.toResponseDTO().apply(customer.get());
    }
}
