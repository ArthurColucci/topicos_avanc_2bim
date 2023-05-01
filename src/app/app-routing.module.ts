import { livroAlugaLstComponent } from './livro-lst/livro-lst.component';
import { livroAlugaFrmComponent } from './livro-frm/livro-frm.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
                        {path:"livroAluga", component:livroAlugaLstComponent}, 
                        {path:"livroAluga/novo", component:livroAlugaFrmComponent},
                        {path:"livroAluga/editar/:id", component:livroAlugaFrmComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
