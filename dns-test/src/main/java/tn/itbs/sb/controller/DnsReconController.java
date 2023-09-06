package tn.itbs.sb.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.itbs.sb.services.DnsReconService;

//@RestController
//@RequestMapping("/dns")
//public class DnsReconController {
//
//    private final DnsReconService dnsReconService;
//
//    @Autowired 
//    public DnsReconController(DnsReconService dnsReconService) {
//        this.dnsReconService = dnsReconService;
//    }
//
////    @GetMapping("/{domain}")
////    public String testdns(@PathVariable String domain) {
////        return dnsReconService.testdns(domain);
////    }
//    
//    @PostMapping("/records/{domain}")
////  public String testdns(@PathVariable String domain) {
////      return dnsReconService.testdns(domain);
////  }
//}


//
//
//
//
//
//
//
//
//@CrossOrigin(origins="http://localhost:4200")
//@RestController
//@RequestMapping("/api")
//public class DnsReconController {
//	
//	 @Autowired
//    private  DnsReconService dnsReconService;
//
//    
//    public DnsReconController(DnsReconService dnsReconService) {
//        this.dnsReconService = dnsReconService;
//    }
//
//    @PostMapping("/records/{domain}")
//    public String testdns(@PathVariable String domain) {
//        return dnsReconService.testdns(domain);
//    }
//    @PostMapping("/zonetransfer/{domain}")
//    public String executeDnsZone(@PathVariable String domain) {
//        return dnsReconService.executeDnsZone(domain);
//    }
//    
//    @PostMapping("/dmarc/{domain}")
//    public String testDMARC(@PathVariable String domain) {
//        return dnsReconService.testDMARC(domain);
//        
//    }
//    
//    @PostMapping("/spf/{domain}")
//    public String testSPF(@PathVariable String domain) {
//    	return dnsReconService.testSPF(domain);
//    }
//    
//}


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
    
//    @GetMapping("/dns/{domain}")
//    public List<String> testdns(@PathVariable String domain) {
//        return dnsService.testdns(domain);
//    }
 
    
    @GetMapping("/bf/{path}/{domain}")
    public String bruteforce(@PathVariable String domain ,@PathVariable String path) {

       return dnsService.bruteforce(domain,path);
    }
    
    
}



