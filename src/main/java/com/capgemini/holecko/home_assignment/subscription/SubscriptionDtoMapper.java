package com.capgemini.holecko.home_assignment.subscription;

import com.capgemini.holecko.home_assignment.customer.Customer;
import com.capgemini.holecko.home_assignment.quotation.Quotation;
import com.capgemini.holecko.home_assignment.utils.Pair;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class SubscriptionDtoMapper implements Function<Pair<Integer, SubscriptionDTO>, Subscription> {
    @Override
    public Subscription apply(Pair<Integer, SubscriptionDTO> idSubscriptionDTOPair) {
        return Subscription.builder()
                .id(idSubscriptionDTOPair.getId())
                .quotation(Quotation.builder()
                        .id(null)
                        .beginningOfInsurance(idSubscriptionDTOPair.getEntity().getQuotation().getBeginningOfInsurance())
                        .insuredAmount(idSubscriptionDTOPair.getEntity().getQuotation().getInsuredAmount())
                        .dateOfSigningMortgage(idSubscriptionDTOPair.getEntity().getQuotation().getDateOfSigningMortgage())
                        .customer(Customer.builder()
                                .id(null)
                                .firstName(idSubscriptionDTOPair.getEntity().getQuotation().getCustomer().getFirstName())
                                .lastName(idSubscriptionDTOPair.getEntity().getQuotation().getCustomer().getLastName())
                                .middleName(idSubscriptionDTOPair.getEntity().getQuotation().getCustomer().getMiddleName())
                                .email(idSubscriptionDTOPair.getEntity().getQuotation().getCustomer().getEmail())
                                .phoneNumber(idSubscriptionDTOPair.getEntity().getQuotation().getCustomer().getPhoneNumber())
                                .birthDate(idSubscriptionDTOPair.getEntity().getQuotation().getCustomer().getBirthDate())
                                .build())
                        .build())
                .startDate(idSubscriptionDTOPair.getEntity().getStartDate())
                .validUntil(idSubscriptionDTOPair.getEntity().getValidUntil())
                .build();
    }
}
