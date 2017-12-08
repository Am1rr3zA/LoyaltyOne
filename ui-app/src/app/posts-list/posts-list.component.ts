import { Component, OnInit } from '@angular/core';
import { PostModel } from '../model/postModel';
import { Observer } from 'rxjs/Observer';
import { store } from '../loyalty-one/app-data';

@Component({
  selector: 'posts-list',
  templateUrl: './posts-list.component.html',
  styleUrls: ['./posts-list.component.css']
})
export class PostsListComponent implements Observer<PostModel[]>, OnInit {

  posts: PostModel[] = [];

  ngOnInit() {
    store.postsList$.subscribe(this);
  }

  next(data: PostModel[]) {
    console.log('Posts list component rceived data ...');
    this.posts = data;
  }

  error (err: any) {
    console.error(err);
  }

  complete() {
    console.log('completed');
  }

  constructor() { }



}
