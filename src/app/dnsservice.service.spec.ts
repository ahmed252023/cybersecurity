import { TestBed } from '@angular/core/testing';

import { DNSService } from './dnsservice.service';

describe('DnsserviceService', () => {
  let service: DNSService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DNSService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });});
