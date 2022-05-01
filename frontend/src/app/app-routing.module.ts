import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryFormComponent } from './component/category-form/category-form.component';
import { CategoryListComponent } from './component/category-list/category-list.component';
import { CategoryUpdateComponent } from './component/category-update/category-update.component';
import { LoginComponent } from './component/login/login.component';
import { ProductFormComponent } from './component/product-form/product-form.component';
import { ProductListComponent } from './component/product-list/product-list.component';
import { ProductUpdateComponent } from './component/product-update/product-update.component';

const routes: Routes = [
  
  {path: 'category', component: CategoryListComponent },
  {path: 'category-post', component: CategoryFormComponent },
  {path: 'category-update/:id', component: CategoryUpdateComponent },
  {path: 'product', component: ProductListComponent },
  {path: 'product-post', component: ProductFormComponent},
  {path: 'product-update/:id',component: ProductUpdateComponent},
  {path: 'login', component: LoginComponent},

  { path: '', redirectTo: 'category' , pathMatch: 'full'}
 

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
