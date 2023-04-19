package com.capgemini.holecko.home_assignment.subscription;

import com.capgemini.holecko.home_assignment.customer.Customer;
import com.capgemini.holecko.home_assignment.customer.CustomerDTOResponse;
import com.capgemini.holecko.home_assignment.quotation.Quotation;
import com.capgemini.holecko.home_assignment.quotation.QuotationDTOResponse;
import com.capgemini.holecko.home_assignment.utils.Pair;

import java.util.function.Function;

public class SubscriptionMapper {

    private SubscriptionMapper() {
    }

    public static Function<Pair<Integer, SubscriptionDTO>, Subscription> toEntity() {
        return subscriptionIdPair -> Subscription.builder()
                .id(subscriptionIdPair.getId())
                .quotation(Quotation.builder()
                        .id(null)
                        .beginningOfInsurance(subscriptionIdPair.getEntity().quotation().beginningOfInsurance())
                        .insuredAmount(subscriptionIdPair.getEntity().quotation().insuredAmount())
                        .dateOfSigningMortgage(subscriptionIdPair.getEntity().quotation().dateOfSigningMortgage())
                        .customer(Customer.builder()
                                .id(null)
                                .firstName(subscriptionIdPair.getEntity().quotation().customer().firstName())
                                .lastName(subscriptionIdPair.getEntity().quotation().customer().lastName())
                                .middleName(subscriptionIdPair.getEntity().quotation().customer().middleName())
                                .email(subscriptionIdPair.getEntity().quotation().customer().email())
                                .phoneNumber(subscriptionIdPair.getEntity().quotation().customer().phoneNumber())
                                .birthDate(subscriptionIdPair.getEntity().quotation().customer().birthDate())
                                .build())
                        .build())
                .startDate(subscriptionIdPair.getEntity().startDate())
                .validUntil(subscriptionIdPair.getEntity().validUntil())
                .build();
    }

    public static Function<Subscription, SubscriptionDTOResponse> toResponseDTO() {
        return subscription -> SubscriptionDTOResponse.builder()
                .id(subscription.getId())
                .quotation(QuotationDTOResponse.builder()
                        .id(subscription.getQuotation().getId())
                        .beginningOfInsurance(subscription.getQuotation().getBeginningOfInsurance())
                        .insuredAmount(subscription.getQuotation().getInsuredAmount())
                        .dateOfSigningMortgage(subscription.getQuotation().getDateOfSigningMortgage())
                        .customer(CustomerDTOResponse.builder()
                                .id(subscription.getQuotation().getCustomer().getId())
                                .firstName(subscription.getQuotation().getCustomer().getFirstName())
                                .lastName(subscription.getQuotation().getCustomer().getLastName())
                                .middleName(subscription.getQuotation().getCustomer().getMiddleName())
                                .email(subscription.getQuotation().getCustomer().getEmail())
                                .phoneNumber(subscription.getQuotation().getCustomer().getPhoneNumber())
                                .birthDate(subscription.getQuotation().getCustomer().getBirthDate())
                                .build())
                        .build())
                .startDate(subscription.getStartDate())
                .validUntil(subscription.getValidUntil())
                .build();
    }
}
