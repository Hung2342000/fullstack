import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from '../../model/category';
import { CategoryService } from '../../service/category.service';
import {AuthService} from "../../service/auth.service";
import {TokenService} from "../../service/token.service";

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  roles !: string[]
  categorys !: Category[]   ;
  constructor(
    private categoryService : CategoryService,
    private router :  Router,
    private tokenService : TokenService
  ) { }

  ngOnInit(): void {
    this.roles = this.tokenService.getRoles();
    console.log(this.roles);

    if(this.roles === null ){
      this.router.navigate(['login']);
    }
    else {
      if( this.roles.includes('list_category') === false ){
        this.router.navigate(['401']);
      }
      else{this.getCategory();}
    }


  }
  getCategory(){
    this.categoryService.getCategoryList().subscribe(
      data =>{
      this.categorys = data;
    }
    );
  }
  addCategory(){
    this.router.navigate(['category-post']);
  }

   updateCategory(id : number){
      this.router.navigate(['category-update',id]);
  }

  deleteCategory(id : number){
    this.categoryService.deleteCategory(id).subscribe(data =>
      {
        this.getCategory();
      }
      )
}
}
