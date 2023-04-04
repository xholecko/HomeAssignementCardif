package com.capgemini.holecko.home_assignment.subscription;

import com.capgemini.holecko.home_assignment.utils.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class SubscriptionServiceImpl implements SubscriptionService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private SubscriptionDAO subscriptionDAO;

    @Autowired
    private SubscriptionDtoMapper subscriptionDtoMapper;

    @Override
    public Subscription create(SubscriptionDTO subscription) {
        Subscription result = subscriptionDAO.save(subscriptionDtoMapper.apply(new Pair<>(null, subscription)));
        log.info("Creation of new subscription is successful. {}", result);
        return result;
    }

    @Override
    public Subscription findById(Integer subscriptionId) {
        Optional<Subscription> subscriptionFromDB = subscriptionDAO.findById(subscriptionId);
        if (subscriptionFromDB.isEmpty()) {
            String errorMessage = "Can not retrieve subscription. Subscription with given ID does not exists.";
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
