package com.capgemini.holecko.home_assignment.subscription;

import com.capgemini.holecko.home_assignment.quotation.QuotationDTO;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record SubscriptionDTO(
        QuotationDTO quotation,
        LocalDate startDate,
        LocalDate validUntil
) {
}
