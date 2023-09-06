package tn.itbs.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.itbs.sb.services.DnsReconService;
import tn.itbs.sb.services.EmailService;
import tn.itbs.sb.services.ScanService;



@RestController
@RequestMapping("/api")
public class ScanController {
		@Autowired
		private final ScanService scanservice;

	    
	    public ScanController(ScanService scan) {
	        this.scanservice = scan;
	    }
	    
	  
	    
	    @GetMapping("/scan/{ip}")
	    public String nmapscan(@PathVariable String ip) {
	    	return scanservice.nmapscan(ip);
	  }
	 

}
