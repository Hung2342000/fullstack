import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {User} from "../model/user";
import {Role} from "../model/role";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) {
  }

  private url = 'http://localhost:8080/user/';

  public getUserList() : Observable<User[]>{
    return this.httpClient.get<User[]>(this.url + "list");
  }

  //post
  public postUser(user : User) : Observable<Object>{
    return this.httpClient.post<User>(this.url + 'post', user);

  }

  public deleteUser(id: number) : Observable<Object>{
    return this.httpClient.delete<User>(this.url + 'delete/' + id);
  }
}
