import { Injectable } from '@angular/core';
import { livroAluga } from '../models/livroAluga';

@Injectable({
  providedIn: 'root'
})
export class livroAlugaService {

  constructor() { }
  livroAluga: livroAluga[] = [];
  count: number = 1;


  public inserir(livroAluga:livroAluga):void{

    livroAluga.id = this.count;
    
  
    this.livroAluga.push(livroAluga);
    this.count = this.count + 1;
  }
  obterTodos(): livroAluga[] {
    return this.livroAluga;
  }

   //terminar
   public remover(id: number): boolean {

    var ind: number = -1;
    for (let i = 0; i <= this.livroAluga.length; i++) {
      if (this.livroAluga[i].id == id) {
        ind = i;
        break;
      }
    }
    this.livroAluga.splice(ind, 1);
    console.log(this.livroAluga);
    return true;
  }

  //terminar e melhorar o id
  public alterar(livroAluga: livroAluga): livroAluga {
    var ind: number = -1;
    for (let i = 0; i <= this.livroAluga.length; i++) {
      if (this.livroAluga[i].id == livroAluga.id) {
        ind = i;
        break;
      }
    }
    this.livroAluga[ind] = livroAluga;
    return livroAluga;
  }

  public obterPorId(id: number): livroAluga {

    var ind: number = -1;
    for (let i = 0; i <= this.livroAluga.length; i++) {
      if (this.livroAluga[i].id == id) {
        ind = i;
        break;
      }
    }
    return this.livroAluga[ind];
  }


}
