package com.capgemini.holecko.home_assignment.subscription;

public interface SubscriptionService {

    /**
     * Creates new SubscriptionDTO object if it does not exist, otherwise subscription will be updated.
     *
     * @param subscription subscription
     * @return newly created subscription
     */
    Subscription create(Subscription subscription);

    /**
     * Retrieves subscription from database.
     *
     * @param subscription subscription
     * @return newly created subscription
     */
    Subscription retrieve(Integer subscriptionId);
}
