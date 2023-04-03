package com.capgemini.holecko.home_assignment.quotation;

import com.capgemini.holecko.home_assignment.customer.CustomerDTO;
import jakarta.transaction.Transactional;
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
class QuotationServiceImplTest {

    @Autowired
    private QuotationService quotationService;

    @Test
    void contextLoadsTest() {
        assertNotNull(quotationService);
    }

    @Test
    void testCreate() {
        QuotationDTO quotation = QuotationDTO.builder()
                .beginningOfInsurance(LocalDate.of(2020, 1, 1))
                .insuredAmount(1)
                .dateOfSigningMortgage(LocalDate.of(2021, 2, 2))
                .customer(CustomerDTO.builder()
                        .firstName("Mark")
                        .lastName("Hall")
                        .middleName(null)
                        .email("mark.hall@email.cz")
                        .phoneNumber("777888999")
                        .birthDate(LocalDate.of(1990, 1, 2))
                        .build())
                .build();

        QuotationDTO quotation2 = QuotationDTO.builder()
                .beginningOfInsurance(LocalDate.of(2022, 3, 3))
                .insuredAmount(2)
                .dateOfSigningMortgage(LocalDate.of(2020, 4, 4))
                .customer(CustomerDTO.builder()
                        .firstName("Peter")
                        .lastName("Doll")
                        .middleName("Steve")
                        .email("peter.steve.doll@email.cz")
                        .phoneNumber("123456789")
                        .birthDate(LocalDate.of(1991, 1, 2))
                        .build())
                .build();

        assertEquals(0, quotationService.findAll().size());
        quotationService.create(quotation);
        assertEquals(1, quotationService.findAll().size());
        quotationService.create(quotation2);
        assertEquals(2, quotationService.findAll().size());
    }
}
