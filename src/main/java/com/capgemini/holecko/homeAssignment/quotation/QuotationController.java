package com.capgemini.holecko.homeAssignment.quotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quotation")
public class QuotationController {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private QuotationService quotationService;
}
