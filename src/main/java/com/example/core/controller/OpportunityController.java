package com.example.core.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.core.domain.Opportunity;
import com.example.core.response.ResponseMessage;
import com.example.core.service.OpportunityService;
import com.example.core.utils.CSVHelper;

@RestController
@RequestMapping("/api")
public class OpportunityController {

	@Autowired(required = true)
	OpportunityService opportunityService;

	@GetMapping(value = "/opportunityList")
	public List<Opportunity> getOpportunities() {
		return opportunityService.findAll();
	}

	@GetMapping(value = "/opportunity")
	public Optional<Opportunity> getOpportunityById(@RequestBody Opportunity opportunity) {
		return opportunityService.findById(opportunity);
	}

	@PostMapping(value = "/createOpportunity")
	public Opportunity createOpportunity(@RequestBody Opportunity opportunity) {
		return opportunityService.insertOpportunity(opportunity);
	}

	@PutMapping(value = "/updateOpportunity")
	public Opportunity updateOpportunity(@RequestBody Opportunity opportunity) {
		return opportunityService.updateOpportunity(opportunity);
	}

	@DeleteMapping(value = "/deleteOpportunityById")
	public void deleteOpportunity(@RequestBody Opportunity opportunity) {
		opportunityService.deleteOpportunity(opportunity);
	}

	/*
	 * Uploading a csv file and reading and storing it in to db
	 */
	@PostMapping("/uploadOpportunityCSVFile")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";

		if (CSVHelper.hasCSVFormat(file)) {
			try {
				opportunityService.uploadCSVFile(file);

				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}

		message = "Please upload a csv file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}

}
