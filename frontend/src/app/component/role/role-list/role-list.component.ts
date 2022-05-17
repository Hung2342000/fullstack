import { Component, OnInit } from '@angular/core';
import {Role} from "../../../model/role";
import {RoleService} from "../../../service/role.service";
import {Router} from "@angular/router";
import {dashCaseToCamelCase} from "@angular/compiler/src/util";

@Component({
  selector: 'app-role-list',
  templateUrl: './role-list.component.html',
  styleUrls: ['./role-list.component.css']
})
export class RoleListComponent implements OnInit {

  roles !: Role[];
  constructor(
    private roleService : RoleService,
    private router :  Router
  ) { }

  ngOnInit(): void {
    this.getRole();
  }

  getRole(){
    this.roleService.getRoleList().subscribe(
      data => { this.roles = data ; console.log("data",data); console.log(this.roles);}

    )
  }

  addRole(){
    this.router.navigate(['role-post']);
  }
}
