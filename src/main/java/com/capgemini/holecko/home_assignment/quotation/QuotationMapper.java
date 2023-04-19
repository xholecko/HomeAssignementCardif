package com.capgemini.holecko.home_assignment.quotation;

import com.capgemini.holecko.home_assignment.customer.Customer;
import com.capgemini.holecko.home_assignment.customer.CustomerDTOResponse;
import com.capgemini.holecko.home_assignment.utils.Pair;

import java.util.function.Function;

public class QuotationMapper {

    private QuotationMapper() {
    }

    public static Function<Pair<Integer, QuotationDTO>, Quotation> toEntity() {
        return quotationIdPair -> Quotation.builder()
                .id(quotationIdPair.getId())
                .beginningOfInsurance(quotationIdPair.getEntity().beginningOfInsurance())
                .insuredAmount(quotationIdPair.getEntity().insuredAmount())
                .dateOfSigningMortgage(quotationIdPair.getEntity().dateOfSigningMortgage())
                .customer(Customer.builder()
                        .id(null)
                        .firstName(quotationIdPair.getEntity().customer().firstName())
                        .lastName(quotationIdPair.getEntity().customer().lastName())
                        .middleName(quotationIdPair.getEntity().customer().middleName())
                        .email(quotationIdPair.getEntity().customer().email())
                        .phoneNumber(quotationIdPair.getEntity().customer().phoneNumber())
                        .birthDate(quotationIdPair.getEntity().customer().birthDate())
                        .build())
                .build();
    }

    public static Function<Quotation, QuotationDTOResponse> toResponseDTO() {
        return quotation -> QuotationDTOResponse.builder()
                .id(quotation.getId())
                .beginningOfInsurance(quotation.getBeginningOfInsurance())
                .insuredAmount(quotation.getInsuredAmount())
                .dateOfSigningMortgage(quotation.getDateOfSigningMortgage())
                .customer(CustomerDTOResponse.builder()
                        .id(quotation.getCustomer().getId())
                        .firstName(quotation.getCustomer().getFirstName())
                        .lastName(quotation.getCustomer().getLastName())
                        .middleName(quotation.getCustomer().getMiddleName())
                        .email(quotation.getCustomer().getEmail())
                        .phoneNumber(quotation.getCustomer().getPhoneNumber())
                        .birthDate(quotation.getCustomer().getBirthDate())
                        .build())
                .build();
    }
}
