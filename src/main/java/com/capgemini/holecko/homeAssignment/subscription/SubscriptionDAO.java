package com.capgemini.holecko.homeAssignment.subscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionDAO extends JpaRepository<SubscriptionDTO, Integer> {
}
