import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import {TokenService} from "../service/token.service";
@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(
    private token: TokenService
  ) { }
  intercept(req: HttpRequest<any>, next: HttpHandler) {
    let authReq = req;
    let token = this.token.getToken();
    if (token != null) {
      authReq = req.clone({ headers: req.headers.set("Authorization", 'Bearer ' + token) });
    }
    return next.handle(authReq);
  }
}
