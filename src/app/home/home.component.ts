import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor(private router: Router) {}

  navigateToscan() {
    this.router.navigate(['/scan']);
  }

  navigateTogetemail() {
    this.router.navigate(['/get_email']);
  }

  navigateTodnstest() {
    this.router.navigate(['/dns']);
  }
}