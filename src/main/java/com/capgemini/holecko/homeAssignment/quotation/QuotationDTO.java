package com.capgemini.holecko.homeAssignment.quotation;

import com.capgemini.holecko.homeAssignment.customer.CustomerDTO;
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
@Table(name = "quotation")
@Data
public class QuotationDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "beginning_of_insurance")
    private String beginningOfInsurance;

    @Column(name = "insured_amount")
    private Integer insuredAmount;

    @Column(name = "date_of_signing_mortgage")
    private LocalDate dateOfSigningMortgage;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CustomerDTO customer;
}
