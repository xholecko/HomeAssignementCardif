package com.capgemini.holecko.home_assignment.customer;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        CustomerDTO customer = CustomerDTO.builder()
                .firstName("Mark")
                .lastName("Hall")
                .middleName(null)
                .email("mark.hall@email.cz")
                .phoneNumber("777888999")
                .birthDate(LocalDate.of(1990, 1, 2))
                .build();

        CustomerDTOResponse customerFromDb = customerService.create(customer);

        assertEquals(1, customerService.findAll().size());

        CustomerDTO updatedCustomerDTO = CustomerDTO.builder()
                .firstName(customerFromDb.firstName())
                .lastName(customerFromDb.lastName())
                .middleName("Martin")
                .email("mark.martin.hall@email.cz")
                .phoneNumber(null)
                .birthDate(customerFromDb.birthDate())
                .build();

        CustomerDTOResponse updatedCustomerFromDb = customerService.update(updatedCustomerDTO, customerFromDb.id());
        assertEquals(1, customerService.findAll().size());
        assertEquals(customerFromDb.id(), updatedCustomerFromDb.id());
        assertEquals(updatedCustomerDTO.middleName(), updatedCustomerFromDb.middleName());
        assertEquals(updatedCustomerDTO.email(), updatedCustomerFromDb.email());
        assertEquals(updatedCustomerDTO.phoneNumber(), updatedCustomerFromDb.phoneNumber());
    }

    @Test
    void testUpdateException() {
        CustomerDTO customer = CustomerDTO.builder()
                .firstName("Mark")
                .lastName("Hall")
                .middleName(null)
                .email("mark.hall@email.cz")
                .phoneNumber("777888999")
                .birthDate(LocalDate.of(1990, 1, 2))
                .build();

        Assertions.assertThrows(CustomerException.class, () -> {
            customerService.update(customer, null);
        });

        CustomerDTOResponse customerFromDb = customerService.create(customer);

        assertEquals(1, customerService.findAll().size());

        Assertions.assertThrows(CustomerException.class, () ->
                customerService.update(customer, customerFromDb.id() + 1)
        );
    }
}
