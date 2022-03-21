import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/category';
import { Product } from 'src/app/model/product';
import { CategoryService } from 'src/app/service/category.service';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  product : Product = new Product();
  id !: number;
  category !: Category[];
  constructor(
    private productService : ProductService,
    private categoryService : CategoryService,
    private route: ActivatedRoute,
    private router: Router

  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.getCategory();
    this.productService.getById(this.id).subscribe(data => this.product = data)
  }
  private getCategory(){
    this.categoryService.getCategoryList().subscribe(
      data =>{
      this.category = data;
      console.log(this.category);
    }
    );

  }
  onSubmit(){
    this.productService.updateProduct(this.id,this.product).subscribe(data => this.goToProductList())
    console.log("okee")
  };
  goToProductList(){
    this.router.navigate(['/product'])
  }

}
