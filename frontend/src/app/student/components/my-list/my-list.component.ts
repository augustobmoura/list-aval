import { Component } from '@angular/core';
import { map } from 'rxjs/operators';
import { ApiAvaliacoesResolucaoService, AvaliacaoResolucaoLista, Turma } from '../../../../../lib/server-client/src';

export interface listModel {
  title: string;
  class: string;
  date: Date;
  id: number;
  publicado?: boolean;
}

@Component({
  selector: 'app-my-list',
  templateUrl: './my-list.component.html',
  styleUrls: ['./my-list.component.scss'],
})
export class MyListComponent {

  minhasAvaliacoes: Promise<AvaliacaoResolucaoLista[]> = this._defaultService.findAll().pipe(
    map(it => it.content),
  ).toPromise();

  constructor(
    private readonly _defaultService: ApiAvaliacoesResolucaoService,
  ) {
  }

  buildTitle(turma: Turma) {
    return `${turma.disciplina.nome} (${turma.semestre})`;
  }
}
