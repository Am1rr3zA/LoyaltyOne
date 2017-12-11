import { Component, OnInit, Input} from '@angular/core';
import { PostModel } from '../model/postModel';
import { Observer } from 'rxjs/Observer';
import { store } from '../loyalty-one/app-data';
import { User } from '../model/user';
import { UserService } from '../services/user.service';
import { PostsService } from '../services/posts.service';
import { CommentService } from '../services/comment.service';

@Component({
  selector: 'post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css'],
  host: { 'style': 'width: 100%;'}
})
export class PostComponent {

  @Input() post: PostModel;

  addcomment(id: string) {
    this.commentService.setId(id);
  }

  constructor(private commentService: CommentService) { }
}
