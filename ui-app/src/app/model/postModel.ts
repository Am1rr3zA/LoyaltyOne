export class PostModel {
   id: number;
   text: string;
   user_id: number;

   constructor(text: string, user_id: number) {
       this.text = text;
       this.user_id = user_id;
    }
}
