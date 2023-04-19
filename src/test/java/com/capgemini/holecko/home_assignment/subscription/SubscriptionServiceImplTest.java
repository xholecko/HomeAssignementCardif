package com.capgemini.holecko.home_assignment.subscription;

import com.capgemini.holecko.home_assignment.customer.CustomerDTO;
import com.capgemini.holecko.home_assignment.quotation.QuotationDTO;
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
class SubscriptionServiceImplTest {

    @Autowired
    private SubscriptionService subscriptionService;

    @Test
    void contextLoadsTest() {
        assertNotNull(subscriptionService);
    }

    @Test
    void testCreate() {
        SubscriptionDTO subscription = SubscriptionDTO.builder()
                .quotation(QuotationDTO.builder()
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
                        .build())
                .startDate(LocalDate.of(2019, 1, 1))
                .validUntil(LocalDate.of(2019, 12, 12))
                .build();

        SubscriptionDTO subscription2 = SubscriptionDTO.builder()
                .quotation(QuotationDTO.builder()
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
                        .build())
                .startDate(LocalDate.of(2018, 1, 1))
                .validUntil(LocalDate.of(2018, 12, 12))
                .build();

        assertEquals(0, subscriptionService.findAll().size());
        subscriptionService.create(subscription);
        assertEquals(1, subscriptionService.findAll().size());
        subscriptionService.create(subscription2);
        assertEquals(2, subscriptionService.findAll().size());
    }

    @Test
    void testFindById() {
        SubscriptionDTO subscription = new SubscriptionDTO(
                QuotationDTO.builder()
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
                        .build(),
                LocalDate.of(2019, 1, 1),
                LocalDate.of(2019, 12, 12)
        );
        assertEquals(0, subscriptionService.findAll().size());
        SubscriptionDTOResponse subscriptionFromDb = subscriptionService.create(subscription);
        assertEquals(1, subscriptionService.findAll().size());
        SubscriptionDTOResponse foundSubscriptionById = subscriptionService.findById(subscriptionFromDb.id());
        assertEquals(subscriptionFromDb, foundSubscriptionById);
    }
}
