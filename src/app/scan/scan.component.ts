import { Component } from '@angular/core';
import { DNSService } from '../dnsservice.service';
import { HttpClient } from '@angular/common/http';
import { Location } from '@angular/common';

@Component({
  selector: 'app-scan',
  templateUrl: './scan.component.html',
  styleUrls: ['./scan.component.css']
})
export class ScanComponent {
  sUpdateFormActive = false;
  isResultLoaded= false;
  ip: string="";
  
  
  
  output: string="";

  isLoading =false;
 
  constructor(private  scanservice: DNSService ,private http: HttpClient, private location: Location) 
  { 
    
  }
  goBack() {
    this.location.back(); // This navigates back to the previous location
  }


  scannmap() : void {
    alert("please wait ..." )
    this.scanservice.scan(this.ip).subscribe(response => {
      
        this.output = response;
        
      }, error => {
        this.output = 'Error executing nmap.\n' + error;
        
      });
     
  }
}
