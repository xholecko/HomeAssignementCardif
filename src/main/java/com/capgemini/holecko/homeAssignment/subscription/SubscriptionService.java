package com.capgemini.holecko.homeAssignment.subscription;

public interface SubscriptionService {

    /**
     * Creates new SubscriptionDTO object if it does not exist, otherwise subscription will be updated.
     *
     * @param subscription subscription
     * @return newly created subscription
     */
    SubscriptionDTO create(SubscriptionDTO subscription);

    /**
     * Retrieves subscription from database.
     *
     * @param subscription subscription
     * @return newly created subscription
     */
    SubscriptionDTO retrieve(Integer subscriptionId);
}
