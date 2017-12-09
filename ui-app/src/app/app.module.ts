import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { LoyaltyOneComponent } from './loyalty-one/loyalty-one.component';
import { PostsListComponent } from './posts-list/posts-list.component';
import { PostsService } from './services/posts.service';


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
  providers: [PostsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
