import { Component, OnInit } from '@angular/core';
import {Role} from "../../../model/role";
import {Permission} from "../../../model/permission";
import {RoleService} from "../../../service/role.service";
import {PermissionService} from "../../../service/permission.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-role-from',
  templateUrl: './role-from.component.html',
  styleUrls: ['./role-from.component.css']
})
export class RoleFromComponent implements OnInit {

  role : Role = new Role();
  permissions !: Permission[];
  constructor(
    private roleService : RoleService,
    private permissionService : PermissionService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.getPermission();
  }

  getPermission(){
    this.permissionService.getPermissionList().subscribe(data => {
      this.permissions = data;
      console.log(this.permissions)
    })
  }

  saveRole(){
    console.log(this.role);
    this.roleService.postRole(this.role).subscribe(data => {
      this.goToList();
      console.log(data);
    })
  }
  goToList() {
    this.router.navigate(['/role']);
  }

  onSubmit(){
    this.saveRole();
  }


}
