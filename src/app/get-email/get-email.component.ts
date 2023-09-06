import { Component } from '@angular/core';
import { DNSService } from '../dnsservice.service';
import { HttpClient } from '@angular/common/http';
import { Location } from '@angular/common';

@Component({
  selector: 'app-get-email',
  templateUrl: './get-email.component.html',
  styleUrls: ['./get-email.component.css']
})
export class GetEmailComponent {
  EmailArray : any[] = [];
  isUpdateFormActive = false;
  isResultLoaded= false;
  domain: string="";
  
  
  
  
  emails: string="";

  constructor(private  dnsReconService: DNSService ,private http: HttpClient, private location: Location) 
  { 
    // this.GetEmail();
  }
  goBack() {
    this.location.back(); // This navigates back to the previous location
  }

  GetEmail() {
   
    this.dnsReconService.GetEmail(this.domain).subscribe((resultData: any)=>
      {
          this.isResultLoaded = true;
          console.log(resultData);
          this.EmailArray = resultData;
      });
    
    
    
  }
    
    
  //   subscribe(
  //     response => {
      
  //     return this.output = response;
        
  //       return this.output;
  //     }, error => {
  //       return this.output = 'Error executing email .\n' + error;
  //     });


  // }

}
