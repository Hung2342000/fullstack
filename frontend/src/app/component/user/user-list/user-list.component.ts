import { Component, OnInit } from '@angular/core';
import {User} from "../../../model/user";
import {UserService} from "../../../service/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users !: User[];
  constructor(
    private userService : UserService,
    private router :  Router
  ) { }

  ngOnInit(): void {
    this.getUser();
  }

  getUser(){
    this.userService.getUserList().subscribe(
      data => {
        this.users = data;
      }
    )
  }
  addUser(){
    this.router.navigate(['/user-post'])
  }

}
