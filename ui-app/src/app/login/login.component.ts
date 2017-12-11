import { Component, OnInit } from '@angular/core';
import { PostModel } from '../model/postModel';
import { HttpClient } from '@angular/common/http';
import { PostsService } from '../services/posts.service';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  host: { 'style': 'width: 100%;'}
})
export class LoginComponent implements OnInit {

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {

  }

  login(username: string, password: string) {
    this.userService.login(username, password).subscribe(
      (user) => {
        console.log('Hello');
        console.log(user);
        this.router.navigateByUrl('/home/' + user.id);
      } ,
      console.error
    );
  }
}
