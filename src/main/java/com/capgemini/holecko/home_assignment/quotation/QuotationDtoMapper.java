package com.capgemini.holecko.home_assignment.quotation;

import com.capgemini.holecko.home_assignment.customer.Customer;
import com.capgemini.holecko.home_assignment.utils.Pair;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class QuotationDtoMapper implements Function<Pair<Integer, QuotationDTO>, Quotation> {
    @Override
    public Quotation apply(Pair<Integer, QuotationDTO> idQuotationDTOPair) {
        return Quotation.builder()
                .id(idQuotationDTOPair.getId())
                .beginningOfInsurance(idQuotationDTOPair.getEntity().getBeginningOfInsurance())
                .insuredAmount(idQuotationDTOPair.getEntity().getInsuredAmount())
                .dateOfSigningMortgage(idQuotationDTOPair.getEntity().getDateOfSigningMortgage())
                .customer(Customer.builder()
                        .id(null)
                        .firstName(idQuotationDTOPair.getEntity().getCustomer().getFirstName())
                        .lastName(idQuotationDTOPair.getEntity().getCustomer().getLastName())
                        .middleName(idQuotationDTOPair.getEntity().getCustomer().getMiddleName())
                        .email(idQuotationDTOPair.getEntity().getCustomer().getEmail())
                        .phoneNumber(idQuotationDTOPair.getEntity().getCustomer().getPhoneNumber())
                        .birthDate(idQuotationDTOPair.getEntity().getCustomer().getBirthDate())
                        .build())
                .build();
    }
}
