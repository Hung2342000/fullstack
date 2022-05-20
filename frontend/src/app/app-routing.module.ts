import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryFormComponent } from './component/category-form/category-form.component';
import { CategoryListComponent } from './component/category-list/category-list.component';
import { CategoryUpdateComponent } from './component/category-update/category-update.component';
import { LoginComponent } from './component/login/login.component';
import { ProductFormComponent } from './component/product-form/product-form.component';
import { ProductListComponent } from './component/product-list/product-list.component';
import { ProductUpdateComponent } from './component/product-update/product-update.component';
import {RoleListComponent} from "./component/role/role-list/role-list.component";
import {RoleFromComponent} from "./component/role/role-from/role-from.component";
import {UserListComponent} from "./component/user/user-list/user-list.component";
import {UserFormComponent} from "./component/user/user-form/user-form.component";
import {HomeComponent} from "./component/home/home.component";
import {UnauthorizationComponent} from "./component/unauthorization/unauthorization.component";

const routes: Routes = [

  {path: 'category', component: CategoryListComponent },
  {path: 'category-post', component: CategoryFormComponent },
  {path: 'category-update/:id', component: CategoryUpdateComponent },
  {path: 'product', component: ProductListComponent },
  {path: 'product-post', component: ProductFormComponent},
  {path: 'product-update/:id',component: ProductUpdateComponent},
  {path: 'role', component: RoleListComponent },
  {path: 'role-post', component: RoleFromComponent },
  {path: 'user', component: UserListComponent },
  {path: 'user-post', component: UserFormComponent },
  {path: 'login', component: LoginComponent},
  {path: '401', component: UnauthorizationComponent},
  {path: 'home', component: HomeComponent},

  { path: '', redirectTo: 'category' , pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
