import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from '../model/category';
@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  // may cai chung chung nhu localhost hay cau hinh thi e tim hieu cach cau hinh enviroment nhe
  private urlGet = 'http://localhost:8080/category/list';
  private urlPost = 'http://localhost:8080/category/post';
  private urlUpdate = 'http://localhost:8080/category/';
  private urlU = 'http://localhost:8080/category/put/';
  private urlDelete = 'http://localhost:8080/category/delete/';
  constructor(private httpClient: HttpClient) { 
    
  }
  //list
  public getCategoryList() : Observable<Category[]>{
    return this.httpClient.get<Category[]>(this.urlGet);
  }
  //post
  public postCategory(category : Category) : Observable<Object>{
    return this.httpClient.post<Category>(this.urlPost, category);
    
  }

   public getCategoryById(id: number): Observable<Category>{
    return this.httpClient.get<Category>(this.urlUpdate + id );
   }

   public updateCategory(id: number,category : Category): Observable<Object>{
    return this.httpClient.put(this.urlU + id ,category)
   }

   public deleteCategory(id: number): Observable<Object>{
    return this.httpClient.delete(this.urlDelete + id)
   }

}
