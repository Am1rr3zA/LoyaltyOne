import { Component, OnInit } from '@angular/core';
import { PostModel } from '../model/postModel';
import { Observer } from 'rxjs/Observer';
import { store } from '../loyalty-one/app-data';
import { User } from '../model/user';
import { UserService } from '../services/user.service';
import { PostsService } from '../services/posts.service';

@Component({
  selector: 'posts-list',
  templateUrl: './posts-list.component.html',
  styleUrls: ['./posts-list.component.css']
})
export class PostsListComponent implements Observer<PostModel[]>, OnInit {

  posts: PostModel[] = [];
  private login_user: User;
  public obj: any = this;

  ngOnInit() {
    store.postsList$.subscribe(this);
    this.userSerivce.user$.subscribe(user => this.obj.login_user = user);
    this.postsService.getAllPostByUser(this.login_user.id.toString()).subscribe(
      res => this.obj.posts = res
    );
    store.initializePostsList(this.obj.posts);
  }

  next(data: PostModel[]) {
    console.log('Posts list component rceived data ...');
    this.obj.posts = data;
  }

  error (err: any) {
    console.error(err);
  }

  complete() {
    console.log('completed');
  }

  constructor(private postsService: PostsService, private userSerivce: UserService) { }



}
