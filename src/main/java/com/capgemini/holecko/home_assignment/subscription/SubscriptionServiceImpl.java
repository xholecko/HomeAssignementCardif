package com.capgemini.holecko.home_assignment.subscription;

import com.capgemini.holecko.home_assignment.customer.CustomerDTO;
import com.capgemini.holecko.home_assignment.quotation.QuotationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private SubscriptionDAO subscriptionDAO;

    @Override
    public SubscriptionDTO create(SubscriptionDTO subscription) {
        Optional<SubscriptionDTO> subscriptionFromDB = subscriptionDAO.findById(subscription.getId());
        if (subscriptionFromDB.isEmpty()) {
            // todo what if existing customer or quotation will be provided?
            if (subscription.getQuotation() == null) {
                log.warn("Quotation does not exist, new empty quotation will be created");
                subscription.setQuotation(new QuotationDTO());
            }
            if (subscription.getQuotation().getCustomer() == null) {
                log.warn("Customer does not exist, new empty customer will be created");
                subscription.getQuotation().setCustomer(new CustomerDTO());
            }
            return subscriptionDAO.save(subscription);
        }
        String errorMessage = "Can not create new subscription. Subscription with given ID already exists : " + subscriptionFromDB.get();
        log.error(errorMessage);
        throw new SubscriptionException(errorMessage);
    }

    @Override
    public SubscriptionDTO retrieve(Integer subscriptionId) {
        Optional<SubscriptionDTO> subscriptionFromDB = subscriptionDAO.findById(subscriptionId);
        if (subscriptionFromDB.isEmpty()) {
            String errorMessage = "Can not retrieve subscription. Subscription with given ID does not exists";
            log.error(errorMessage);
            throw new SubscriptionException(errorMessage);
        }
        return subscriptionFromDB.get();
    }
}