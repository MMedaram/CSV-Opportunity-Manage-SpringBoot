package com.example.core.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.core.domain.Opportunity;
import com.example.core.repository.OpportunityRepository;
import com.example.core.service.OpportunityService;
import com.example.core.utils.CSVHelper;

@Service
public class OpportunityServiceImpl implements OpportunityService {

	@Autowired
	OpportunityRepository opportunityRepository;

	@Override
	public List<Opportunity> findAll() {
		return opportunityRepository.findAll();
		}

	@Override
	public Optional<Opportunity> findById(Opportunity opportunity) {
		return opportunityRepository.findById(opportunity.getId());
	}

	@Override
	public Opportunity insertOpportunity(Opportunity opportunity) {
		return opportunityRepository.save(opportunity);
	}

	@Override
	public Opportunity updateOpportunity(Opportunity opportunity) {
		return opportunityRepository.save(opportunity);
	}

	@Override
	public void deleteOpportunity(Opportunity opportunity) {
		opportunityRepository.delete(opportunity);

	}

	@Override
	public void uploadCSVFile(MultipartFile file) {
		 try {
		      List<Opportunity> opportunites = CSVHelper.csvToOpportunities(file.getInputStream());
		      opportunityRepository.saveAll(opportunites);
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store csv data: " + e.getMessage());
		    }		
	}

}
