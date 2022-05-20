import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {UserService} from "../../service/user.service";
import {User} from "../../model/user";
import {AuthService} from "../../service/auth.service";
import {TokenService} from "../../service/token.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  users !: User[];
  userLogin : User = new User();

  constructor(
    private router : Router,
    private userService : UserService,
    private authService : AuthService,
    private tokenService : TokenService
  ) {}

  ngOnInit(): void {
    console.log(this.userLogin);
  }

  onSubmit(){
    this.authService.login(this.userLogin).subscribe(data =>
      {
        console.log(data);
        this.tokenService.saveToken(data.token);
        this.tokenService.setRoles(data.roles);
        this.router.navigate(['/home']);
      },
    error => alert("Tên đăng nhập hoặc mật khẩu không đúng")
    )

  }

}
