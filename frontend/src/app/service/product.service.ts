import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private url = 'http://localhost:8080/products/';
  constructor(private httpClient: HttpClient) { }

  //list
  public getProductList() : Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.url + 'list');
  }
  public postProduct(product: Product) : Observable<Object>{
    return this.httpClient.post<Product>(this.url + 'post',product);
  }

  public getById(id: number) : Observable<Product>{
    return this.httpClient.get<Product>(this.url + id);
  }
  // cho nay truoc a bao r sau nay chi dung 2 phuong thuc do la get voi post thoi
  public updateProduct(id: number, product: Product) : Observable<Object>{
    return this.httpClient.put<Product>(this.url + 'put/' + id,product);
  }
  
  public deleteProduct(id: number) : Observable<Object>{
    return this.httpClient.delete<Product>(this.url + 'delete/' + id);
  }

}
