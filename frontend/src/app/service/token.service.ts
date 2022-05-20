import { Injectable } from '@angular/core';
import {User} from "../model/user";
import {Login} from "../model/login";
const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';
@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }

  public saveToken(token : any){
    window.localStorage.setItem("token",token );
  }

  public getToken(): any {
    return window.localStorage.getItem("token");
  }

  public setRoles(role : any){
    window.localStorage.setItem('role',role);
  }

  public getRoles(): any{
    return window.localStorage.getItem('role');
  }

  public logout(){
    window.localStorage.clear();
  }

}
