import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from '../../model/category';
import { CategoryService } from '../../service/category.service';

@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html',
  styleUrls: ['./category-form.component.css']
})
export class CategoryFormComponent implements OnInit {
  category: Category = new Category();
  constructor(
    private categoryService : CategoryService,
    private route: ActivatedRoute,
    private router: Router
    ) {}

  ngOnInit(): void {
  }

  saveCategory(){
    this.categoryService.postCategory(this.category).subscribe(data => {
      console.log("okee");
      this.goToCategoryList()
    },
    error => console.log(error)
    );
  }

  goToCategoryList() {
    this.router.navigate(['/category']);
  }
  onSubmit(){
    this.saveCategory();
  }

}
