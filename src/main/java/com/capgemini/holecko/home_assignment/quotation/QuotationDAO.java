package com.capgemini.holecko.home_assignment.quotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotationDAO extends JpaRepository<Quotation, Integer> {
}
