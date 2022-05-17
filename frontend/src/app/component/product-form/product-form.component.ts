import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Category } from 'src/app/model/category';
import { Product } from 'src/app/model/product';
import { CategoryService } from 'src/app/service/category.service';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {

  product : Product = new Product();
  category !: Category[];

  productForm = new FormGroup({
    nameProduct :new FormControl(),
    price :new FormControl(),
    category :new FormControl(),

  })

  constructor(
    private categoryService : CategoryService,
    private router: Router,
    private productService : ProductService

  ) { }

  ngOnInit(): void {
    this.getCategory();

  }
  private getCategory(){
    this.categoryService.getCategoryList().subscribe(
      data =>{
      this.category = data;
      console.log(this.category);
    }
    );

  }
  saveProduct(){

    this.productService.postProduct(this.productForm.value).subscribe(data => {
    this.goToProductList();
    console.log(data);
     });
  }

  goToProductList() {
    this.router.navigate(['/product']);
  }
  onSubmit(){
    this.saveProduct();
  }
}


