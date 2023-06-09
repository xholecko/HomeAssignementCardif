package com.capgemini.holecko.home_assignment.quotation;

import com.capgemini.holecko.home_assignment.customer.CustomerDTO;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record QuotationDTO(
        LocalDate beginningOfInsurance,
        Integer insuredAmount,
        LocalDate dateOfSigningMortgage,
        CustomerDTO customer
) {
}
