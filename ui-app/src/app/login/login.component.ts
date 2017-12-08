import { Component, OnInit } from '@angular/core';
import { PostModel } from '../model/postModel';
import { HttpClient } from '@angular/common/http';
import { PostResource } from '../resource/resource';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private postGet: PostModel = new PostModel('');
  private postPost: PostModel = new PostModel('');

  constructor(private resource: PostResource, private http: HttpClient) { }

  ngOnInit() {

  }

  public showGetRequest(text: string) {
    this.resource.getText(text).subscribe((res: PostModel) => {
      this.postGet = res;
      console.log(res);
    });
  }

  public showPostRequest(text: string) {
    this.resource.postText(text).subscribe((res: PostModel) => {
      this.postPost = res;
      console.log(res);
    });
  }

}
