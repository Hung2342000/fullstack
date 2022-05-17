import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {UserService} from "../../service/user.service";
import {User} from "../../model/user";

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
    private userService : UserService
  ) {}

  ngOnInit(): void {
    this.getUser();
  }

  getUser(){
    this.userService.getUserList().subscribe(data => {
      this.users = data;
    })
  }

  onSubmit(){
    let test = false;
    console.log(this.userLogin);
    for (let i=0;i<this.users.length ; i++) {
      if(this.userLogin.email === this.users[i].email &&
        this.userLogin.password === this.users[i].password){
        console.log("okee");
        test = true;
      }
    }

    if(test === true){
      this.goToCategoryList()
    }
    else {
      alert("thất bại");
    }
  }

  goToCategoryList() {
    this.router.navigate(['/category']);
  }

}
