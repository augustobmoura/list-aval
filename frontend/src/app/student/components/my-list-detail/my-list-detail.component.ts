import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { mergeMap } from 'rxjs/operators';
import { ApiAvaliacoesResolucaoService, ApiAvaliacoesService, AvaliacaoLista } from '../../../../../lib/server-client/src';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-my-list-detail',
  templateUrl: './my-list-detail.component.html',
  styleUrls: ['./my-list-detail.component.scss']
})
export class MyListDetailComponent implements OnInit {

  avaliacao: Observable<AvaliacaoLista> = this._activedRoute.params.pipe(
    mergeMap(params => this.apiAvaliacoesService.findByIdAvaliacoes(+params.id)),
  );

  avaliacoesRespostas = this._activedRoute.params.pipe(
    mergeMap(params => this.apiAvaliacoesResolucaoService.findAllByAvaliacaoResolucaoLista(+params['id'])),
  );

  isRevision = false;

  constructor(
    private readonly _activedRoute: ActivatedRoute,
    private readonly apiAvaliacoesService: ApiAvaliacoesService,
    private readonly apiAvaliacoesResolucaoService: ApiAvaliacoesResolucaoService,
  ) {
  }

  ngOnInit() {
  }

  toogleRevistion() {
    this.isRevision = !this.isRevision;
  }


}
