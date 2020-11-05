package com.dbadapters.core.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.dbadapters.core.domain.Opportunity;
import com.dbadapters.core.response.ResponseMessage;

@Component
public interface OpportunityService {

	public List<Opportunity> findAll();

	public Optional<Opportunity> findById(Opportunity opportunity);

	public Opportunity insertOpportunity(Opportunity opportunity);

	public Opportunity updateOpportunity(Opportunity opportunity);

	public void deleteOpportunity(Opportunity opportunity);

	public void uploadCSVFile(MultipartFile file);

	public ResponseEntity<ResponseMessage> createOpportunityByReadingExcel() throws IOException;
}
