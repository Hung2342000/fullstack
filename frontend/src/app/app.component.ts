import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "./service/auth.service";
import {Token} from "@angular/compiler";
import {TokenService} from "./service/token.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  constructor( private router: Router, private authService: AuthService,private tokenService : TokenService) {

  }

  ngOnInit(): void {
    if(!this.tokenService.getToken()){
      this.router.navigate(['/login']);
    }
  }

  logout() {
    this.tokenService.logout();
    this.router.navigate(['/login']);
  }
}
