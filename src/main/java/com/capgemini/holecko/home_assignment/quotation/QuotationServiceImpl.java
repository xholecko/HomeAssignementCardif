package com.capgemini.holecko.home_assignment.quotation;

import com.capgemini.holecko.home_assignment.customer.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuotationServiceImpl implements QuotationService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private QuotationDAO quotationDAO;

    @Override
    public Quotation create(Quotation quotation) {
        Optional<Quotation> quotationFromDB = Optional.empty();
        if (quotation.getId() != null) {
            quotationFromDB = quotationDAO.findById(quotation.getId());
        }

        if (quotationFromDB.isPresent()) {
            String errorMessage = "Can not create new quotation. Quotation with given ID already exists : " + quotationFromDB.get();
            log.error(errorMessage);
            throw new QuotationException(errorMessage);
        }

        if (quotation.getCustomer() != null && quotation.getCustomer().getId() != null) {
            log.warn("Customer ID is provided, newly created customer will be created instead.");
            quotation.getCustomer().setId(null);
        } else if (quotation.getCustomer() == null) {
            log.warn("Customer does not exist, new empty customer will be created");
            quotation.setCustomer(new Customer());
        }

        Quotation result = quotationDAO.save(quotation);
        log.info("Creation of new quotation is successful. {}", result);
        return result;
    }

    @Override
    public List<Quotation> findAll() {
        return quotationDAO.findAll();
    }

    @Override
    public Quotation findById(Integer quotationId) {
        Optional<Quotation> quotation = quotationDAO.findById(quotationId);
        if (quotation.isEmpty()) {
            String errorMessage = "Can not find new quotation. Quotation with given ID does not exists.";
            log.error(errorMessage);
            throw new QuotationException(errorMessage);
        }
        log.info("Find quotation by id is successful. {}", quotation.get());
        return quotation.get();
    }
}
