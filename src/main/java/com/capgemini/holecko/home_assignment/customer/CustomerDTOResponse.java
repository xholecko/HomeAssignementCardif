package com.capgemini.holecko.home_assignment.customer;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CustomerDTOResponse(
        Integer id,
        String firstName,
        String lastName,
        String middleName,
        String email,
        String phoneNumber,
        LocalDate birthDate
) {
}
