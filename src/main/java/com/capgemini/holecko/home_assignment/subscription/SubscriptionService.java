package com.capgemini.holecko.home_assignment.subscription;

import java.util.List;

public interface SubscriptionService {

    /**
     * @param newSubscription new subscription
     * @return newly created subscription
     */
    SubscriptionDTOResponse create(SubscriptionDTO newSubscription);

    /**
     * @return all subscriptions from DB
     */
    List<SubscriptionDTOResponse> findAll();

    /**
     * @param subscriptionId subscription id
     * @return subscription from database with given ID
     * @throws com.capgemini.holecko.home_assignment.subscription.Subscription if subscription does not exist
     */
    SubscriptionDTOResponse findById(Integer subscriptionId);
}
