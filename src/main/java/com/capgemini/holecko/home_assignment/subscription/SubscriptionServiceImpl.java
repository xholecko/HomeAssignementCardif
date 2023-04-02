package com.capgemini.holecko.home_assignment.subscription;

import com.capgemini.holecko.home_assignment.customer.Customer;
import com.capgemini.holecko.home_assignment.quotation.Quotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private SubscriptionDAO subscriptionDAO;

    @Override
    public Subscription create(Subscription subscription) {
        Optional<Subscription> subscriptionFromDB = Optional.empty();
        if (subscription.getId() != null) {
            subscriptionFromDB = subscriptionDAO.findById(subscription.getId());
        }

        if (subscriptionFromDB.isPresent()) {
            String errorMessage = "Can not create new subscription. Subscription with given ID already exists : " + subscriptionFromDB.get();
            log.error(errorMessage);
            throw new SubscriptionException(errorMessage);
        }

        if (subscription.getQuotation() != null && subscription.getQuotation().getId() != null) {
            log.warn("Quotation ID is provided, newly created quotation will be created instead.");
            subscription.getQuotation().setId(null);
        } else if (subscription.getQuotation() == null) {
            log.warn("Quotation does not exist, new empty quotation will be created");
            subscription.setQuotation(new Quotation());
        }
        if (subscription.getQuotation().getCustomer() != null && subscription.getQuotation().getCustomer().getId() != null) {
            log.warn("Customer ID is provided, newly created customer will be created instead.");
            subscription.getQuotation().getCustomer().setId(null);
        } else if (subscription.getQuotation().getCustomer() == null) {
            log.warn("Customer does not exist, new empty customer will be created");
            subscription.getQuotation().setCustomer(new Customer());
        }

        Subscription result = subscriptionDAO.save(subscription);
        log.info("Creation of new subscription is successful. {}", result);
        return result;
    }

    @Override
    public Subscription findById(Integer subscriptionId) {
        Optional<Subscription> subscriptionFromDB = subscriptionDAO.findById(subscriptionId);
        if (subscriptionFromDB.isEmpty()) {
            String errorMessage = "Can not retrieve subscription. Subscription with given ID does not exists";
            log.error(errorMessage);
            throw new SubscriptionException(errorMessage);
        }

        log.info("Retrieving subscription from db is successful. {}", subscriptionFromDB.get());
        return subscriptionFromDB.get();
    }

    @Override
    public List<Subscription> findAll() {
        return subscriptionDAO.findAll();
    }
}
