import { Component, OnInit } from '@angular/core';
import { store } from './app-data';
import { PostModel } from '../model/postModel';
import { PostsService } from '../services/posts.service';
import { UserService } from '../services/user.service';
import { User } from '../model/user';

@Component({
  selector: 'loyalty-one',
  templateUrl: './loyalty-one.component.html',
  styleUrls: ['./loyalty-one.component.css']
})
export class LoyaltyOneComponent implements OnInit {

  private login_user: User;
  constructor(private postsService: PostsService, private userSerivce: UserService) { }

  ngOnInit() {

  }

  addPost(postText: HTMLInputElement) {
    this.userSerivce.user$.subscribe(user => this.login_user = user);

    if (postText.value !== null && postText.value !== ' '  && postText.value !== '') {
      this.postsService.postText(postText.value, this.login_user.id).subscribe((res: PostModel) => {
        store.addPost(res);
        postText.value = '';
      });
    }
  }

}
