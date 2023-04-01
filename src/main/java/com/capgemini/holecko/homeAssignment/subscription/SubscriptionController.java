package com.capgemini.holecko.homeAssignment.subscription;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private SubscriptionService subscriptionService;
}
