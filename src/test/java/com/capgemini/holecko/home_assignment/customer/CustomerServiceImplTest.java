package com.capgemini.holecko.home_assignment.customer;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Test
    void contextLoadsTest() {
        assertNotNull(customerService);
    }

    @Test
    void testUpdate() {
        Customer customer = new Customer(
                null,
                "Mark",
                "Hall",
                null,
                "mark.hall@email.cz",
                "777888999",
                LocalDate.of(1990, 1, 2)
        );

        Customer customerFromDb = customerService.create(customer);

        assertEquals(1, customerService.findAll().size());

        customerFromDb.setMiddleName("Martin");
        customerFromDb.setEmail("mark.martin.hall@email.cz");
        customerFromDb.setPhoneNumber(null);

        Customer updatedCustomerFromDb = customerService.update(customerFromDb);
        assertEquals(1, customerService.findAll().size());
        assertEquals(customerFromDb.getId(), updatedCustomerFromDb.getId());
        assertEquals(customerFromDb.getMiddleName(), updatedCustomerFromDb.getMiddleName());
        assertEquals(customerFromDb.getEmail(), updatedCustomerFromDb.getEmail());
        assertEquals(customerFromDb.getPhoneNumber(), updatedCustomerFromDb.getPhoneNumber());
    }

    @Test
    void testUpdateException() {
        Customer customer = new Customer(
                null,
                "Mark",
                "Hall",
                null,
                "mark.hall@email.cz",
                "777888999",
                LocalDate.of(1990, 1, 2)
        );

        Assertions.assertThrows(CustomerException.class, () -> {
            customerService.update(customer);
        });

        Customer customerFromDb = customerService.create(customer);

        assertEquals(1, customerService.findAll().size());

        customerFromDb.setId(customer.getId() + 1);

        Assertions.assertThrows(CustomerException.class, () -> {
            customerService.update(customerFromDb);
        });
    }
}
