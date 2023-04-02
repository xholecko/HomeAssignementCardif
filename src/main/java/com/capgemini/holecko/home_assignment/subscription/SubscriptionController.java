package com.capgemini.holecko.home_assignment.subscription;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/insert")
    public Subscription insert(@RequestBody Subscription subscription) {
        log.info("Calling /api/subscription/insert");
        return subscriptionService.create(subscription);
    }

    @GetMapping("/retrieve/{subscriptionId}")
    public Subscription retrieve(@PathVariable Integer subscriptionId) {
        log.info("Calling /api/subscription/retrieve/{}", subscriptionId);
        return subscriptionService.findById(subscriptionId);
    }
}
