package com.example.core.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.example.core.domain.Opportunity;

public class CSVHelper {
	  public static String TYPE = "text/csv";
	  static String[] HEADERs = { "ID", "OPPORTUITY_NAME", "ACCOUNT_NAME", "EXP_BOOK_DATE","EXP_PRODUCT","EXP_SERVICE","EXIST_OPP_NAME","OPP_URL"};

	  public static boolean hasCSVFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }

	  public static List<Opportunity> csvToOpportunities(InputStream is) {
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

	      List<Opportunity> opportunities = new ArrayList<Opportunity>();

	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

	      for (CSVRecord csvRecord : csvRecords) {
	    	  Opportunity opportunity = new Opportunity(
	    		  csvRecord.get("OPPORTUITY_NAME"),
	              csvRecord.get("ACCOUNT_NAME"),
	              csvRecord.get("EXP_BOOK_DATE"),
	             csvRecord.get("EXP_PRODUCT"),
	    		  csvRecord.get("EXP_SERVICE"),
	              csvRecord.get("EXIST_OPP_NAME"),
	              csvRecord.get("OPP_URL")
	            );

	    	  opportunities.add(opportunity);
	      }

	      return opportunities;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }

	  /*public static ByteArrayInputStream tutorialsToCSV(List<Employee> tutorials) {
	    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

	    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
	        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
	      for (Employee tutorial : tutorials) {
	        List<String> data = Arrays.asList(
	              String.valueOf(tutorial.getId()),
	              tutorial.getTitle(),
	              tutorial.getDescription(),
	              String.valueOf(tutorial.isPublished())
	            );

	        csvPrinter.printRecord(data);
	      }

	      csvPrinter.flush();
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
	    }
	  }
*/	

}