import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'StockMarket';
  userLoggedIn : boolean = false;

  constructor(private authService: AuthService) {}

  ngDoCheck(){
    this.userLoggedIn = this.authService.isUserLoggedIn();
  }
}
