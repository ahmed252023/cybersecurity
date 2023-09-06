package tn.itbs.sb.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.itbs.sb.services.DnsReconService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping("/api")
public class DnsReconController {
    @Autowired
    private final DnsReconService dnsService;
    
    public DnsReconController(DnsReconService dnsService) {
        this.dnsService = dnsService;
    }
    
  
    
    @GetMapping("/dns/{domain}")
    public String testdns(@PathVariable String domain) {
    	return dnsService.testdns(domain);
  }
    

 
    
    @GetMapping("/bf/{path}/{domain}")
    public String bruteforce(@PathVariable String domain ,@PathVariable String path) {

       return dnsService.bruteforce(domain,path);
    }
    
    
}



