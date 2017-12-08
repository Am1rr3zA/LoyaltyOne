import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginResource } from './login/resource';
import { LoyaltyOneComponent } from './loyalty-one/loyalty-one.component';
import { PostsListComponent } from './posts-list/posts-list.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LoyaltyOneComponent,
    PostsListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [LoginResource],
  bootstrap: [AppComponent]
})
export class AppModule { }
