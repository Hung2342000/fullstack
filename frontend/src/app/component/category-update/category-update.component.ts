import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Category } from '../../model/category';
import { CategoryService } from '../../service/category.service';

@Component({
  selector: 'app-category-update',
  templateUrl: './category-update.component.html',
  styleUrls: ['./category-update.component.css']
})
export class CategoryUpdateComponent implements OnInit {

  id : number = 0 ;
  category : Category = new Category();

  constructor(
    private categoryService : CategoryService,
    private route: ActivatedRoute,
    private router: Router,
  ) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];
    console.log(this.id);

    this.categoryService.getCategoryById(this.id).subscribe(data => {
      this.category = data
      console.log("data", data);
    },error => console.log(error));

  }

  onSubmit(){
    this.categoryService.updateCategory( this.id, this.category).subscribe( data=> {
        this.goToCategoryList();
      },error => console.log(error));
  }
  goToCategoryList() {
    this.router.navigate(['/category']);
  }

}
