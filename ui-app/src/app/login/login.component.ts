import { Component, OnInit } from '@angular/core';
import { PostModel } from '../model/postModel';
import { HttpClient } from '@angular/common/http';
import { PostsService } from '../services/posts.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private postGet: PostModel = new PostModel('');
  private postPost: PostModel = new PostModel('');

  constructor(private postsService: PostsService, private http: HttpClient) { }

  ngOnInit() {

  }

  public showGetRequest(text: string) {
    this.postsService.getText(text).subscribe((res: PostModel) => {
      this.postGet = res;
      console.log(res);
    });
  }

  public showPostRequest(text: string) {
    this.postsService.postText(text).subscribe((res: PostModel) => {
      this.postPost = res;
      console.log(res);
    });
  }

}
