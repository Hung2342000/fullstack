import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../model/category";
import {Role} from "../model/role";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class RoleService {
  private url = 'http://localhost:8080/role/';
  constructor(
    private httpClient: HttpClient
  ) { }

  //list
  public getRoleList() : Observable<Role[]>{
    return this.httpClient.get<Role[]>(this.url + "list");
  }

  //post
  public postRole(role : Role) : Observable<Object>{
    return this.httpClient.post<Role>(this.url + 'post', role);

  }

  public deleteRole(id: number) : Observable<Object>{
    return this.httpClient.delete<Role>(this.url + 'delete/' + id);
  }
}
