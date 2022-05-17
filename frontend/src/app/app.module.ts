import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CategoryListComponent } from './component/category-list/category-list.component';
import { CategoryFormComponent } from './component/category-form/category-form.component';
import { FormsModule } from '@angular/forms';
import { CategoryUpdateComponent } from './component/category-update/category-update.component';
import { ProductListComponent } from './component/product-list/product-list.component';
import { ProductFormComponent } from './component/product-form/product-form.component';
import { ProductUpdateComponent } from './component/product-update/product-update.component';
import { ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './component/login/login.component';
import { RoleListComponent } from './component/role/role-list/role-list.component';
import { RoleFromComponent } from './component/role/role-from/role-from.component';
import {NgMultiSelectDropDownModule} from "ng-multiselect-dropdown";
import { UserListComponent } from './component/user/user-list/user-list.component';
import { UserFormComponent } from './component/user/user-form/user-form.component';
@NgModule({
  declarations: [
    AppComponent,
    CategoryListComponent,
    CategoryFormComponent,
    CategoryUpdateComponent,
    ProductListComponent,
    ProductFormComponent,
    ProductUpdateComponent,
    LoginComponent,
    RoleListComponent,
    RoleFromComponent,
    UserListComponent,
    UserFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    NgMultiSelectDropDownModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
