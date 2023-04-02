package com.capgemini.holecko.home_assignment.quotation;

import java.util.List;

public interface QuotationService {

    /**
     * Creates new Quotation object if it not exists otherwise exception will be thrown.
     *
     * @param quotation quotation
     * @return newly created quotation
     */
    Quotation create(Quotation quotation);

    /**
     * @return all quotations from DB
     */
    List<Quotation> findAll();

    /**
     * @param quotationId quotation id
     * @return quotation from database with given ID, if quotation does not exist exception will be thrown
     */
    Quotation findById(Integer quotationId);
}
