package com.capgemini.holecko.homeAssignment.quotation;

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
    public QuotationDTO create(QuotationDTO quotation) {
        Optional<QuotationDTO> quotationFromDB = quotationDAO.findById(quotation.getId());
        if (quotationFromDB.isEmpty()) {
            return quotationDAO.save(quotation);
        }
        String errorMessage = "Can not create new quotation. Quotation with given ID already exists : " + quotationFromDB.get();
        log.error(errorMessage);
        throw new QuotationException(errorMessage);
    }
}
