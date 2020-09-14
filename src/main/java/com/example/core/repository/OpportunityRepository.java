package com.example.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.core.domain.Opportunity;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {


}
