package com.capgemini.holecko.home_assignment.subscription;

import java.util.List;

public interface SubscriptionService {

    /**
     * Creates new subscription object if it does not exist, otherwise exception will be thrown.
     *
     * @param subscription subscription
     * @return newly created subscription
     */
    Subscription create(Subscription subscription);

    /**
     * @param subscriptionId subscription id
     * @return subscription from database with given ID, if subscription does not exist exception will be thrown
     */
    Subscription findById(Integer subscriptionId);

    /**
     * @return all subscriptions from DB
     */
    List<Subscription> findAll();
}
