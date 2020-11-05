package com.dbadapters.core.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dbadapters.core.domain.Opportunity;
import com.dbadapters.core.repository.OpportunityRepository;
import com.dbadapters.core.response.ResponseMessage;
import com.dbadapters.core.service.OpportunityService;
import com.dbadapters.core.utils.CSVHelper;

@Service
public class OpportunityServiceImpl implements OpportunityService {


	
	@Autowired(required=true)
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
	public ResponseEntity<ResponseMessage> createOpportunityByReadingExcel() throws IOException {

		
		String path = "src\\main\\resources\\listofOpportunites.csv";
		String message = "";
		File file = new File(path);
		InputStream inputStream = new FileInputStream(file);
		String fileName = file.getName();
	  	try {
			      List<Opportunity> opportunites = CSVHelper.csvToOpportunities(inputStream);
			      opportunityRepository.saveAll(opportunites);
			      message = "The CSV file("+ fileName +") data successfully stored in to Data Base ";
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Somthing went wrong while reading the file: " + fileName + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
	
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
