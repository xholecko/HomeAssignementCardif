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

    @Override
    public SubscriptionDTOResponse create(SubscriptionDTO subscription) {
        Subscription result = subscriptionDAO.save(SubscriptionMapper.toEntity().apply(new Pair<>(null, subscription)));
        log.info("Creation of new subscription is successful. {}", result);
        return SubscriptionMapper.toResponseDTO().apply(result);
    }

    @Override
    public SubscriptionDTOResponse findById(Integer subscriptionId) {
        Optional<Subscription> subscriptionFromDB = subscriptionDAO.findById(subscriptionId);
        if (subscriptionFromDB.isEmpty()) {
            String errorMessage = "Can not retrieve subscription. Subscription with given ID does not exists.";
            log.error(errorMessage);
            throw new SubscriptionException(errorMessage);
        }

        log.info("Retrieving subscription from db is successful. {}", subscriptionFromDB.get());
        return SubscriptionMapper.toResponseDTO().apply(subscriptionFromDB.get());
    }

    @Override
    public List<SubscriptionDTOResponse> findAll() {
        return subscriptionDAO
                .findAll()
                .stream()
                .map(subscription -> SubscriptionMapper.toResponseDTO().apply(subscription))
                .toList();
    }
}
