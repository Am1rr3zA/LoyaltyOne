import { Injectable } from "@angular/core";

@Injectable()
export class CommentService {
    constructor() { }

    public comment: string = null;

    get() {
        return this.comment;
    }

    setId(id: string) {
        this.comment = id;
    }
}
