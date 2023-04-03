package com.capgemini.holecko.home_assignment.quotation;

import java.util.List;

public interface QuotationService {

    /**
     * @param newQuotation new quotation
     * @return newly created quotation
     */
    Quotation create(QuotationDTO newQuotation);

    /**
     * @return all quotations from DB
     */
    List<Quotation> findAll();

    /**
     * @param quotationId quotation id
     * @return quotation from database with given ID
     * @throws com.capgemini.holecko.home_assignment.quotation.QuotationException if quotation does not exist
     */
    Quotation findById(Integer quotationId);
}
