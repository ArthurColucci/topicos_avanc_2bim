import { Component } from '@angular/core';
import { livroAluga } from '../models/livroAluga';
import { ActivatedRoute, Router } from '@angular/router';
import { livroAlugaService } from '../service/livroAlugaService';

@Component({
  selector: 'app-livro-frm',
  templateUrl: './livro-frm.component.html',
  styleUrls: ['./livro-frm.component.css']
})
export class livroAlugaFrmComponent {

  livroAluga: livroAluga = new livroAluga();
  id: number = 0;

  constructor(private router: Router, private route: ActivatedRoute, private livroAlugaService: livroAlugaService) {

  }

  salvar() {
    if (this.id > 0) {
      this.livroAluga.id = this.id;
      this.livroAlugaService.alterar(this.livroAluga);

    }
    else {
      this.livroAlugaService.inserir(this.livroAluga);

    }
    console.log(this.livroAluga);

    this.router.navigate(['/livroAluga']);
  }

  ngOnInit(): void {

    //recuperar o valor do id da rota
    //recupeerar o objeto da lista
    //carregar a tela
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != null) {
        this.id = Number(params.get('id'));
        console.log(this.id);
        this.carregarlivroAluga(this.id);
      }
    });
  };

  carregarlivroAluga(id: number): void {
    this.livroAluga = this.livroAlugaService.obterPorId(id);

  }

  voltar() {

    this.router.navigate(['/livroAluga']);
  }
}
