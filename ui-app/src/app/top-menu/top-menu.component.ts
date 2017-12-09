import { Component, OnInit } from '@angular/core';
import { UserService, UNKNOWN_USER } from '../services/user.service';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import { store } from '../loyalty-one/app-data';

@Component({
  selector: 'top-menu',
  templateUrl: './top-menu.component.html',
  styleUrls: ['./top-menu.component.css']
})
export class TopMenuComponent implements OnInit {

  isLoggedIn$: Observable<boolean>;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.isLoggedIn$ = this.userService.user$.map(user => user !== UNKNOWN_USER);
  }

  logout() {
    this.userService.logout();
    this.router.navigateByUrl('/login');
    store.clearList();
  }

}
