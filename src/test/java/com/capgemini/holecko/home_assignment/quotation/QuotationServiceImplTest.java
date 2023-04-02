package com.capgemini.holecko.home_assignment.quotation;

import com.capgemini.holecko.home_assignment.customer.Customer;
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
class QuotationServiceImplTest {

    @Autowired
    private QuotationService quotationService;

    @Test
    void contextLoadsTest() {
        assertNotNull(quotationService);
    }

    @Test
    void testCreate() {
        Quotation quotation = new Quotation(
                null,
                LocalDate.of(2020, 1, 1),
                1,
                LocalDate.of(2021, 2, 2),
                new Customer(
                        null,
                        "Mark",
                        "Hall",
                        null,
                        "mark.hall@email.cz",
                        "777888999",
                        LocalDate.of(1990, 1, 2)
                )
        );
        Quotation quotation2 = new Quotation(
                null,
                LocalDate.of(2022, 3, 3),
                1,
                LocalDate.of(2020, 4, 4),
                new Customer(
                        null,
                        "Peter",
                        "Doll",
                        "Steve",
                        "peter.steve.doll@email.cz",
                        "123456789",
                        LocalDate.of(1991, 1, 2)
                )
        );
        assertEquals(0, quotationService.findAll().size());
        quotationService.create(quotation);
        assertEquals(1, quotationService.findAll().size());
        quotationService.create(quotation2);
        assertEquals(2, quotationService.findAll().size());
    }

    @Test
    void testCreateException() {
        Quotation quotation = new Quotation(
                null,
                LocalDate.of(2020, 1, 1),
                1,
                LocalDate.of(2021, 2, 2),
                new Customer(
                        null,
                        "Mark",
                        "Hall",
                        null,
                        "mark.hall@email.cz",
                        "777888999",
                        LocalDate.of(1990, 1, 2)
                )
        );
        assertEquals(0, quotationService.findAll().size());
        Quotation quotationFromDb = quotationService.create(quotation);
        assertEquals(1, quotationService.findAll().size());

        Assertions.assertThrows(QuotationException.class, () -> {
            quotationService.create(quotationFromDb);
        });
    }
}
