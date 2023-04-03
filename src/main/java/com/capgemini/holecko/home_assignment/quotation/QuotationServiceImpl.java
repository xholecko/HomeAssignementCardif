package com.capgemini.holecko.home_assignment.quotation;

import com.capgemini.holecko.home_assignment.utils.Pair;
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

    @Autowired
    private QuotationDtoMapper quotationDtoMapper;

    @Override
    public Quotation create(QuotationDTO newQuotation) {
        Quotation result = quotationDAO.save(quotationDtoMapper.apply(new Pair<>(null, newQuotation)));
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
