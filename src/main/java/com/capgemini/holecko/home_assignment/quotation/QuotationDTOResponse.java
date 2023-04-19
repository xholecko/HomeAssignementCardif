package com.capgemini.holecko.home_assignment.quotation;

import com.capgemini.holecko.home_assignment.customer.CustomerDTOResponse;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record QuotationDTOResponse(
        Integer id,
        LocalDate beginningOfInsurance,
        Integer insuredAmount,
        LocalDate dateOfSigningMortgage,
        CustomerDTOResponse customer
) {
}
