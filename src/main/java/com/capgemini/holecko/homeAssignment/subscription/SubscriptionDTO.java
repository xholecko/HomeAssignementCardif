package com.capgemini.holecko.homeAssignment.subscription;

import com.capgemini.holecko.homeAssignment.quotation.QuotationDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "subscription")
@Data
public class SubscriptionDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quotation_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private QuotationDTO quotation;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "valid_until")
    private LocalDate validUntil;
}
