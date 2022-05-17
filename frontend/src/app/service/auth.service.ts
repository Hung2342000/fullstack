import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/user";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  user !: User;
  private url = 'http://localhost:8080/login'
  constructor(
    private httpClient: HttpClient
  ) { }

  public login(user: User) : Observable<any>{
    return this.httpClient.post<any>(this.url, user);
  }
}
