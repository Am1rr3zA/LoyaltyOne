import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import 'rxjs/add/operator/map';
import {HttpClient, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { PostModel } from '../model/postModel';


@Injectable()
export class PostsService {

  private baseUrl = '/api/post';

  constructor(private http: HttpClient) {}

  getText(text: string): Observable<PostModel> {
    const params = new HttpParams().set('name', text);
    return this.http.get<PostModel>(`${this.baseUrl}`, { params: params });
  }

  postText(text: string): Observable<PostModel> {
    const body: PostModel = new PostModel(text);
    return this.http.post<PostModel>(`${this.baseUrl}`, body);
  }

}
