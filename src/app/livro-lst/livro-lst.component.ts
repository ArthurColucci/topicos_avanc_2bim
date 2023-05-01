import { Component } from '@angular/core';
import { livroAluga } from '../models/livroAluga';

import { MatTableDataSource } from '@angular/material/table';
import { livroAlugaService } from '../service/livroAlugaService';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-livro-lst',
  templateUrl: './livro-lst.component.html',
  styleUrls: ['./livro-lst.component.css']
})
export class livroAlugaLstComponent {
  displayedColumns: string[] = ['acoes','id','titulo', 'isbn', 'autor', 'genero', 'nPaginas', 'ano'];

  dataSource = new MatTableDataSource<livroAluga>();

  /**
   *
   */
  constructor(private router: Router, private route: ActivatedRoute,
    private livroAluga: livroAlugaService) {

    this.obterTodos();

  }
  novo(): void {
    this.router.navigate(['/livroAluga/novo']);

  }
  obterTodos(): void {
    this.dataSource.data = this.livroAluga.obterTodos();

  }
  remover(id: number): void {

    var result = confirm("Você irá excluir o seu produto, deseja fazer isso?");
    ind: Number;


    if (result) {
      this.livroAluga.remover(id);

      this.obterTodos();
    }

  }

  alterar(id: number): void {

    this.router.navigate(['/livroAluga/editar/' + id]);

  }
}
