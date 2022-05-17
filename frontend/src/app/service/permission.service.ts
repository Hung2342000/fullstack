import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../model/category";
import {Permission} from "../model/permission";

@Injectable({
  providedIn: 'root'
})
export class PermissionService {
  private url = 'http://localhost:8080/permission/';
  constructor(
    private httpClient: HttpClient
  ) { }

  //list
  public getPermissionList() : Observable<Permission[]>{
    return this.httpClient.get<Permission[]>(this.url + "list");
  }

}
