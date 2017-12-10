export class PostModel {
   id: string;
   text: string;
   user_id: number;

   constructor(text: string, user_id: number) {
       this.id = Math.random().toString(36).substr(2, 13);
       this.text = text;
       this.user_id = user_id;
    }
}
