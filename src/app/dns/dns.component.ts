import { Component } from '@angular/core';
import { DNSService } from '../dnsservice.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Location } from '@angular/common';


@Component({
  selector: 'app-dns',
  templateUrl: './dns.component.html',
  styleUrls: ['./dns.component.css']
})
export class DnsComponent {
  isUpdateFormActive = false;
  isResultLoaded= false;
  domain: string="";
  
  path: string="";
  
  output: string="";
  // currentItem : string ="";

  isLoading =false;
 
  constructor(private  dnsReconService: DNSService ,private http: HttpClient , route:Router,private location: Location) 
  { 
    
  }
  goBack() {
    this.location.back(); 
  }

  
  
  testdns() : void {
    alert("please wait ..." )
    this.dnsReconService.testdns(this.domain).subscribe(response => {
      
        this.output = response;
        
      }, error => {
        this.output = 'Error executing DNS records.\n' + error;
        
      });
     
  }
  





  
  

  bruteforce() {
    alert("please wait ..." )
    this.dnsReconService.bruteforce(this.domain,this.path).subscribe(
      response => {
      
        return this.output = response;
      }, error => {
        return this.output = 'Error executing DNS records.\n' + error;
      });
  }



  // GetEmail() {
    



    
  //   this.dnsReconService.GetEmail(this.domain).subscribe(
  //     response => {
      
  //     return this.output = response;
  //       // for (let i = 0; i < response.length; i++) {
  //       //    this.output = response[i];
  //       //   // Do something with the currentItem
  //       // }
  //       return this.output;
  //     }, error => {
  //       return this.output = 'Error executing email .\n' + error;
  //     });


  // }

  
  
  
}


