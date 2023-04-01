package com.capgemini.holecko.homeAssignment.quotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotationDAO extends JpaRepository<QuotationDTO, Integer> {
}
