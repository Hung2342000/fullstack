import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {User} from "../model/user";
import {BehaviorSubject, Observable} from "rxjs";
import {formatNumber} from "@angular/common";

const AUTH_API = 'http://localhost:8080/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) {

  }

  login(user: User): Observable<any>{
    return this.http.post(AUTH_API + "login",user)
  }



}
