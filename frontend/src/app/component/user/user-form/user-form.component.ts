import { Component, OnInit } from '@angular/core';
import {Role} from "../../../model/role";
import {User} from "../../../model/user";
import {RoleService} from "../../../service/role.service";
import {UserService} from "../../../service/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {

  roles !: Role[];
  user : User = new User();
  constructor(
    private roleService : RoleService,
    private userService : UserService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.getRole();
  }

  getRole(){
    this.roleService.getRoleList().subscribe(data => {
      this.roles = data;
    })
  }
  saveUser(){
    this.userService.postUser(this.user).subscribe(data => this.goToList())
  }
  goToList() {
    this.router.navigate(['/user']);
  }
  onSubmit(){
    this.saveUser();
  }

}
