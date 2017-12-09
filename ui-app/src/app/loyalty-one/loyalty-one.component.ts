import { Component, OnInit } from '@angular/core';
import { store } from './app-data';
import { PostModel } from '../model/postModel';
import { PostsService } from '../services/posts.service';

@Component({
  selector: 'loyalty-one',
  templateUrl: './loyalty-one.component.html',
  styleUrls: ['./loyalty-one.component.css']
})
export class LoyaltyOneComponent implements OnInit {

  constructor(private postsService: PostsService) { }

  ngOnInit() {

  }

  addPost(postText: string) {
    this.postsService.postText(postText).subscribe((res: PostModel) => {
      store.addPost(res);
    });
  }

}
