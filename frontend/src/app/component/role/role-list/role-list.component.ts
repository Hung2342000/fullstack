import { Component, OnInit } from '@angular/core';
import {Role} from "../../../model/role";
import {RoleService} from "../../../service/role.service";
import {Router} from "@angular/router";
import {TokenService} from "../../../service/token.service";

@Component({
  selector: 'app-role-list',
  templateUrl: './role-list.component.html',
  styleUrls: ['./role-list.component.css']
})
export class RoleListComponent implements OnInit {

  roles !: Role[];
  role!: string[]
  constructor(
    private roleService : RoleService,
    private router :  Router,
    private  tokenService : TokenService
  ) { }

  ngOnInit(): void {
    this.role = this.tokenService.getRoles();
    console.log(this.roles);

    if(this.role === null ){
      this.router.navigate(['login']);
    }
    else {
      if( this.role.includes('list_role') === false ){
        this.router.navigate(['401']);
      }
      else{this.getRole();}
    }
  }

  getRole(){
    this.roleService.getRoleList().subscribe(
      data => { this.roles = data ; console.log("data",data); console.log(this.roles);}

    )
  }

  addRole(){
    if(this.role === null ){
      this.router.navigate(['login']);
    }
    else {
      if( this.role.includes('add_role') === false ){
        alert("không có quyền truy cập");
      }
      else{this.router.navigate(['role-post']);}
    }
  }

  deleteRole(id: number){
    if(this.role === null ){
      this.router.navigate(['login']);
    }
    else {
      if( this.role.includes('delete_role') === false ){
        alert("không có quyền truy cập");
      }
      else{this.roleService.deleteRole(id).subscribe(data => this.getRole());}
    }

  }
}
