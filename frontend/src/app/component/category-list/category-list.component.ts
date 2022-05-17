import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from '../../model/category';
import { CategoryService } from '../../service/category.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  categorys !: Category[]   ;
  constructor(
    private categoryService : CategoryService,
    private router :  Router ) { }

  ngOnInit(): void {
    this.getCategory();

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