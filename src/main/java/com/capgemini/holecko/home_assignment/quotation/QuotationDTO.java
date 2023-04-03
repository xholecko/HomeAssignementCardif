package com.capgemini.holecko.home_assignment.quotation;

import com.capgemini.holecko.home_assignment.customer.CustomerDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class QuotationDTO {

    private LocalDate beginningOfInsurance;

    private Integer insuredAmount;

    private LocalDate dateOfSigningMortgage;

    private CustomerDTO customer;
}
