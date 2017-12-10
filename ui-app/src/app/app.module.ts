import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { LoyaltyOneComponent } from './loyalty-one/loyalty-one.component';
import { PostsListComponent } from './posts-list/posts-list.component';
import { PostsService } from './services/posts.service';
import { TopMenuComponent } from './top-menu/top-menu.component';
import { RouterModule } from '@angular/router';
import { routerConfig } from './router.config';
import { UserService } from './services/user.service';
import { CommentService } from './services/comment.service';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LoyaltyOneComponent,
    PostsListComponent,
    TopMenuComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routerConfig)
  ],
  providers: [PostsService, UserService, CommentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
