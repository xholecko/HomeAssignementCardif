package com.capgemini.holecko.home_assignment.subscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionDAO extends JpaRepository<SubscriptionDTO, Integer> {
}
