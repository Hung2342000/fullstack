import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/model/product';
import { ProductService } from 'src/app/service/product.service';
import {Token} from "@angular/compiler";
import {TokenService} from "../../service/token.service";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products !: Product[];
  roles !: string[];
  constructor(
    private router :  Router ,
    private productService : ProductService,
    private tokenService : TokenService,
  ) { }

  ngOnInit(): void {
    this.roles = this.tokenService.getRoles();
    console.log(this.roles);

    if(this.roles === null ){
      this.router.navigate(['login']);
    }
    else {
      if( this.roles.includes('list_product') === false ){
        this.router.navigate(['401']);
      }
      else{this.getProductList();}
    }

  }
  getProductList(){
    this.productService.getProductList().subscribe( data => {
      this.products = data
      console.log(data);
    },error => console.log(error));
  }

  addProduct(){
    if(this.roles === null ){
      this.router.navigate(['login']);
    }
    else {
      if( this.roles.includes('add_product') === false ){
        this.router.navigate(['401']);
      }
      else{this.router.navigate(['product-post']);}
    }

  }

  updateProduct(id: number){
    if(this.roles === null ){
      this.router.navigate(['login']);
    }
    else {
      if( this.roles.includes('edit_product') === false ){
        alert("không có quyền truy cập");
      }
      else{this.router.navigate(['product-update',id]);}
    }

  }

  deleteProduct(id : number){
    if(this.roles === null ){
      this.router.navigate(['login']);
    }
    else {
      if( this.roles.includes('edit_product') === false ){
        alert("không có quyền truy cập");
      }
      else{
        this.productService.deleteProduct(id).subscribe(data =>
        this.getProductList()
      );}
    }

  }



}
