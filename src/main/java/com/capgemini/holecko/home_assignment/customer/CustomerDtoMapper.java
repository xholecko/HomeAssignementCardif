package com.capgemini.holecko.home_assignment.customer;

import com.capgemini.holecko.home_assignment.utils.Pair;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CustomerDtoMapper implements Function<Pair<Integer, CustomerDTO>, Customer> {

    @Override
    public Customer apply(Pair<Integer, CustomerDTO> idCustomerDTOPair) {
        return Customer.builder()
                .id(idCustomerDTOPair.getId())
                .firstName(idCustomerDTOPair.getEntity().getFirstName())
                .lastName(idCustomerDTOPair.getEntity().getLastName())
                .middleName(idCustomerDTOPair.getEntity().getMiddleName())
                .email(idCustomerDTOPair.getEntity().getEmail())
                .phoneNumber(idCustomerDTOPair.getEntity().getPhoneNumber())
                .birthDate(idCustomerDTOPair.getEntity().getBirthDate())
                .build();
    }
}
