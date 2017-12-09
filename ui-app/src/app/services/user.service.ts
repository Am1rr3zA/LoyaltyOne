import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { User } from '../model/user';
import 'rxjs/add/observable/of';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import 'rxjs/add/operator/do';

export const UNKNOWN_USER: User = {
  firstname: 'UnKnown'
};

@Injectable()
export class UserService {

  private baseUrl = '/api/login';

  private subject = new BehaviorSubject(UNKNOWN_USER);

  user$: Observable<User> = this.subject.asObservable();

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<User> {
    return this.http.post<User>(`${this.baseUrl}`, {username, password})
    .do(user => console.log(user))
    .do(user => this.subject.next(user));
  }

  logout() {
    this.subject.next(UNKNOWN_USER);
  }

}
