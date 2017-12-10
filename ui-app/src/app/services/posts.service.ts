import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import 'rxjs/add/operator/map';
import {HttpClient, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { PostModel } from '../model/postModel';
import { City } from '../model/city';


@Injectable()
export class PostsService {

  private baseUrl = '/api/post';

  constructor(private http: HttpClient) {}

  getText(text: string): Observable<PostModel> {
    const params = new HttpParams().set('name', text);
    return this.http.get<PostModel>(`${this.baseUrl}`, { params: params });
  }

  getAllPostByUser(user_id: string): Observable<PostModel[]> {
    const params = new HttpParams().set('id', user_id);
    return this.http.get<PostModel[]>(`${this.baseUrl}`, { params: params });
  }

  postText(text: string, user_id: number, parent_id: string, city: City): Observable<PostModel> {
    const body: PostModel = new PostModel(text, user_id, parent_id);
    body.city = city;
    return this.http.post<PostModel>(`${this.baseUrl}`, body);
  }

}
