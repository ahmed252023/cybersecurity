import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DnsComponent } from './dns/dns.component';
import { ScanComponent } from './scan/scan.component';
import { HomeComponent } from './home/home.component';
import { GetEmailComponent } from './get-email/get-email.component';

const routes: Routes = [
  { path: '', redirectTo: '', pathMatch: 'full' },
  { path: 'scan', component: ScanComponent },
  { path: 'dns', component: DnsComponent },
  { path: 'home', component: HomeComponent },
  { path: 'get_email', component: GetEmailComponent },

  








   
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
