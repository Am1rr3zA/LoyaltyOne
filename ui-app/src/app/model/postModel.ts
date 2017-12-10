import { City } from './city';

export class PostModel {
   id: string;
   date?: Date;
   parent_id: string;
   text: string;
   user_id: number;
   city?: City;

   constructor(text: string, user_id: number, parent_id: string) {
       this.id = Math.random().toString(36).substr(2, 13);
       this.text = text;
       this.user_id = user_id;
       this.parent_id = parent_id;
    }

}
