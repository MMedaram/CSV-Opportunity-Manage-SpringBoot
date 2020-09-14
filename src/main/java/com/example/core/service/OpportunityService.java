package com.example.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.core.domain.Opportunity;

@Component
public interface OpportunityService {

	public List<Opportunity> findAll();

	public Optional<Opportunity> findById(Opportunity opportunity);

	public Opportunity insertOpportunity(Opportunity opportunity);

	public Opportunity updateOpportunity(Opportunity opportunity);

	public void deleteOpportunity(Opportunity opportunity);

	public void uploadCSVFile(MultipartFile file);
}
