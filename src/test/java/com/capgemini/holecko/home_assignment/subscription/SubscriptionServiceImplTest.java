package com.capgemini.holecko.home_assignment.subscription;

import com.capgemini.holecko.home_assignment.customer.Customer;
import com.capgemini.holecko.home_assignment.quotation.Quotation;
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
class SubscriptionServiceImplTest {

    @Autowired
    private SubscriptionService subscriptionService;

    @Test
    void contextLoadsTest() {
        assertNotNull(subscriptionService);
    }

    @Test
    void testCreate() {
        Subscription subscription = new Subscription(
                null,
                new Quotation(
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
                ),
                LocalDate.of(2019, 1, 1),
                LocalDate.of(2019, 12, 12)
        );
        Subscription subscription2 = new Subscription(
                null,
                new Quotation(
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
                ),
                LocalDate.of(2018, 1, 1),
                LocalDate.of(2018, 12, 12)
        );
        assertEquals(0, subscriptionService.findAll().size());
        subscriptionService.create(subscription);
        assertEquals(1, subscriptionService.findAll().size());
        subscriptionService.create(subscription2);
        assertEquals(2, subscriptionService.findAll().size());
    }

    @Test
    void testCreateException() {
        Subscription subscription = new Subscription(
                null,
                new Quotation(
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
                ),
                LocalDate.of(2019, 1, 1),
                LocalDate.of(2019, 12, 12)
        );
        assertEquals(0, subscriptionService.findAll().size());
        Subscription subscriptionFromDb = subscriptionService.create(subscription);
        assertEquals(1, subscriptionService.findAll().size());

        Assertions.assertThrows(SubscriptionException.class, () -> {
            subscriptionService.create(subscriptionFromDb);
        });
    }

    @Test
    void testFindById() {
        Subscription subscription = new Subscription(
                null,
                new Quotation(
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
                ),
                LocalDate.of(2019, 1, 1),
                LocalDate.of(2019, 12, 12)
        );
        assertEquals(0, subscriptionService.findAll().size());
        Subscription subscriptionFromDb = subscriptionService.create(subscription);
        assertEquals(1, subscriptionService.findAll().size());
        Subscription foundSubscriptionById = subscriptionService.findById(subscriptionFromDb.getId());
        assertEquals(subscriptionFromDb, foundSubscriptionById);
    }

    @Test
    void testFindByIdException() {
        Subscription subscription = new Subscription(
                null,
                new Quotation(
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
                ),
                LocalDate.of(2019, 1, 1),
                LocalDate.of(2019, 12, 12)
        );
        assertEquals(0, subscriptionService.findAll().size());
        Subscription subscriptionFromDb = subscriptionService.create(subscription);
        assertEquals(1, subscriptionService.findAll().size());

        Assertions.assertThrows(SubscriptionException.class, () -> {
            subscriptionService.findById(subscriptionFromDb.getId() + 1);
        });
    }
}
