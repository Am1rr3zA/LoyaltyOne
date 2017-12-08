import { Component, OnInit } from '@angular/core';
import { store } from './app-data';
import { PostResource } from '../resource/resource';
import { PostModel } from '../model/postModel';

@Component({
  selector: 'loyalty-one',
  templateUrl: './loyalty-one.component.html',
  styleUrls: ['./loyalty-one.component.css']
})
export class LoyaltyOneComponent implements OnInit {

  constructor(private resource: PostResource) { }

  ngOnInit() {

  }

  addPost(postText: string) {
    this.resource.postText(postText).subscribe((res: PostModel) => {
      store.addPost(res);
    });
  }

}
