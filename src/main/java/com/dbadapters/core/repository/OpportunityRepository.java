package com.dbadapters.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbadapters.core.domain.Opportunity;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {


}
