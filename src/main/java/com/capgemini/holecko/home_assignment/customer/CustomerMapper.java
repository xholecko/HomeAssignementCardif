package com.capgemini.holecko.home_assignment.customer;

import com.capgemini.holecko.home_assignment.utils.Pair;

import java.util.function.Function;

public class CustomerMapper {

    private CustomerMapper() {
    }

    public static Function<Pair<Integer, CustomerDTO>, Customer> toEntity() {
        return customerIdPair -> Customer.builder()
                .id(customerIdPair.getId())
                .firstName(customerIdPair.getEntity().firstName())
                .lastName(customerIdPair.getEntity().lastName())
                .middleName(customerIdPair.getEntity().middleName())
                .email(customerIdPair.getEntity().email())
                .phoneNumber(customerIdPair.getEntity().phoneNumber())
                .birthDate(customerIdPair.getEntity().birthDate())
                .build();
    }

    public static Function<Customer, CustomerDTOResponse> toResponseDTO() {
        return customer -> CustomerDTOResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .middleName(customer.getMiddleName())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .birthDate(customer.getBirthDate())
                .build();
    }
}
