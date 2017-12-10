import { Component, OnInit } from '@angular/core';
import { store } from './app-data';
import { PostModel } from '../model/postModel';
import { PostsService } from '../services/posts.service';
import { UserService } from '../services/user.service';
import { User } from '../model/user';
import { City } from '../model/city';
import { CommentService } from '../services/comment.service';

@Component({
  selector: 'loyalty-one',
  templateUrl: './loyalty-one.component.html',
  styleUrls: ['./loyalty-one.component.css']
})
export class LoyaltyOneComponent implements OnInit {

  private login_user: User;
  private parent_id: string;
  constructor(private postsService: PostsService, private userSerivce: UserService,
     private commentService: CommentService) { }

  ngOnInit() {

  }

  getParentId() {
    this.parent_id = this.commentService.get();
    return this.commentService.get();
  }

  addPost(postText: HTMLInputElement, city: HTMLInputElement, latitude: HTMLInputElement,
    longitude: HTMLInputElement, temperature: HTMLInputElement) {
    this.getParentId();
    this.userSerivce.user$.subscribe(user => this.login_user = user);

    if (postText.value !== null && postText.value !== ' '  && postText.value !== '') {
      const cityObj: City = new City();
      cityObj.name = city.value;
      cityObj.latitude = +latitude.value;
      cityObj.longitude = +longitude.value;
      cityObj.temperature = +temperature.value;

      this.postsService.postText(postText.value, this.login_user.id, this.parent_id, cityObj).subscribe((res: PostModel) => {
        store.addPost(res);
        postText.value = '';
        city.value = '';
        latitude.value = '';
        longitude.value = '';
        temperature.value = '';
      });
    }
  }

}
