import { Component, OnInit } from '@angular/core';
import { store } from './app-data';

@Component({
  selector: 'loyalty-one',
  templateUrl: './loyalty-one.component.html',
  styleUrls: ['./loyalty-one.component.css']
})
export class LoyaltyOneComponent implements OnInit {

  constructor() { }

  ngOnInit() {

  }

  addPost(postText: string) {
    const newPost = {
        // id: Math.random(),
        text: postText
    };

    store.addPost(newPost);
  }

}
