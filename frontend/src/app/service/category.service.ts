import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from '../model/category';
@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private url = 'http://localhost:8080/category/';

  constructor(private httpClient: HttpClient) {
  }

  //list
  public getCategoryList() : Observable<Category[]>{
    return this.httpClient.get<Category[]>(this.url + "list");
  }

  //post
  public postCategory(category : Category) : Observable<Object>{
    return this.httpClient.post<Category>(this.url + 'post', category);

  }

   public getCategoryById(id: number): Observable<Category>{
    return this.httpClient.get<Category>(this.url + id );
   }

   //update
   public updateCategory(id: number,category : Category): Observable<Object>{
    return this.httpClient.put(this.url + 'put/' + id ,category)
   }

   //delete
   public deleteCategory(id: number): Observable<Object>{
    return this.httpClient.delete(this.url + 'delete/' + id)
   }

}
