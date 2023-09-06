import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DnsComponent } from './dns/dns.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ScanComponent } from './scan/scan.component';
import { HomeComponent } from './home/home.component';
import { GetEmailComponent } from './get-email/get-email.component';

@NgModule({
  declarations: [
    AppComponent,
    DnsComponent,
    ScanComponent,
    HomeComponent,
    GetEmailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
