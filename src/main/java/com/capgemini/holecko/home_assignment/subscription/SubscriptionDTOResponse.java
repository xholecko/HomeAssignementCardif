package com.capgemini.holecko.home_assignment.subscription;

import com.capgemini.holecko.home_assignment.quotation.QuotationDTOResponse;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record SubscriptionDTOResponse(
        Integer id,
        QuotationDTOResponse quotation,
        LocalDate startDate,
        LocalDate validUntil
) {
}
