package com.capgemini.holecko.home_assignment.quotation;

import com.capgemini.holecko.home_assignment.customer.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuotationServiceImpl implements QuotationService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private QuotationDAO quotationDAO;

    @Override
    public Quotation create(Quotation quotation) {
        Optional<Quotation> quotationFromDB = quotationDAO.findById(quotation.getId());
        if (quotationFromDB.isEmpty()) {
            // todo what if existing customer will be provided?
            if (quotation.getCustomer() == null) {
                log.warn("Customer does not exist, new empty customer will be created");
                quotation.setCustomer(new Customer());
            }
            return quotationDAO.save(quotation);
        }
        String errorMessage = "Can not create new quotation. Quotation with given ID already exists : " + quotationFromDB.get();
        log.error(errorMessage);
        throw new QuotationException(errorMessage);
    }
}
