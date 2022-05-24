import { Component, OnInit } from '@angular/core';
import {User} from "../../../model/user";
import {UserService} from "../../../service/user.service";
import {Router} from "@angular/router";
import {TokenService} from "../../../service/token.service";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  roles !: string[];
  users !: User[];
  constructor(
    private userService : UserService,
    private router :  Router,
    private tokenService : TokenService
  ) { }

  ngOnInit(): void {
    this.roles = this.tokenService.getRoles();
    console.log(this.roles);

    if(this.roles === null ){
      this.router.navigate(['login']);
    }
    else {
      if( this.roles.includes('list_user') === false ){
        this.router.navigate(['401']);
      }
      else{this.getUser();}
    }
  }

  getUser(){
    this.userService.getUserList().subscribe(
      data => {
        this.users = data;
      }
    )
  }
  addUser(){
    if(this.roles === null ){
      this.router.navigate(['login']);
    }
    else {
      if( this.roles.includes('add_user') === false ){
        alert("không có quyền truy cập");
      }
      else{this.router.navigate(['/user-post']);}
    }

  }

  delete(id: number){

    if(this.roles === null ){
      this.router.navigate(['login']);
    }
    else {
      if( this.roles.includes('delete_user') === false ){
        alert("không có quyền truy cập");
      }
      else{ this.userService.deleteUser(id).subscribe(data =>
        this.getUser()
      );}
    }

  }

}
