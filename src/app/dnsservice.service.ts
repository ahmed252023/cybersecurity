import { HttpClient } from '@angular/common/http';
import { Injectable, Output } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DNSService {
  private baseUrl = 'http://localhost:9091/api';

  constructor(private http: HttpClient) { }

  testdns(domain: string): Observable<string> {
    const url = `${this.baseUrl}/dns/${domain}`;
    const option = { responseType : 'text' as const}
    return this.http.get(url, option);
  }
 

  bruteforce(domain: string,path:string): Observable<string> {
    const url = `${this.baseUrl}/bf/${path}/${domain}`;
    return this.http.get(url, { responseType : 'text' });
  }


  GetEmail(domain: string): Observable<string[]>{
    const url = `${this.baseUrl}/get_email/${domain}`;
    return this.http.get<string[]>(url);
  }

  scan(ip: string): Observable<string> {
    const url = `${this.baseUrl}/scan/${ip}`;
    return this.http.get(url, { responseType : 'text' });
  }
}

