package com.capgemini.holecko.home_assignment.subscription;

import com.capgemini.holecko.home_assignment.quotation.QuotationDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SubscriptionDTO {

    private QuotationDTO quotation;

    private LocalDate startDate;

    private LocalDate validUntil;
}
