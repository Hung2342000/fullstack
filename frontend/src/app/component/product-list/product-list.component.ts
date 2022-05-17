import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/model/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products !: Product[];

  constructor(
    private router :  Router ,
    private productService : ProductService
  ) { }

  ngOnInit(): void {
    this.getProductList();
  }
  getProductList(){
    this.productService.getProductList().subscribe( data => {
      this.products = data
      console.log(data);
    },error => console.log(error));
  }

  addProduct(){
    this.router.navigate(['product-post']);
  }

  updateProduct(id: number){
    this.router.navigate(['product-update',id]);
  }

  deleteProduct(id : number){
    this.productService.deleteProduct(id).subscribe(data =>
      this.getProductList()
    );
  }



}
