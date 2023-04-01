package com.capgemini.holecko.homeAssignment.quotation;

public interface QuotationService {

    /**
     * Creates new QuotationDTO object if it not exists otherwise quotation will be updated.
     *
     * @param quotation quotation
     * @return newly created quotation
     */
    QuotationDTO create(QuotationDTO quotation);
}
