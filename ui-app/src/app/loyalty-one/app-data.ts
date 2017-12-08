import { PostModel } from '../model/postModel';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Observable } from 'rxjs/Observable';
import * as _ from 'lodash';

class DataStore {

    private postListSubject = new BehaviorSubject<PostModel[]>([]);

    public postsList$: Observable<PostModel[]> = this.postListSubject.asObservable();

    initializePostsList(newPost: PostModel[]) {
       this.postListSubject.next(_.cloneDeep(newPost));
    }

    addPost(newPost: PostModel) {
        const  posts = this.clonePosts();
        posts.push(_.cloneDeep(newPost));

        this.postListSubject.next(posts);
    }

    private clonePosts() {
        return _.cloneDeep(this.postListSubject.getValue());
    }
}

export const store = new DataStore();
