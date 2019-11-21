import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { mergeMap } from 'rxjs/operators';
import { DefaultService, AvaliacoesResolucaoService, RespostasService, AvaliacaoLista } from '../../../../../lib/server-client/src';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-my-list-detail',
  templateUrl: './my-list-detail.component.html',
  styleUrls: ['./my-list-detail.component.scss']
})
export class MyListDetailComponent implements OnInit {

  avaliacao: Observable<AvaliacaoLista> = this._activedRoute.params.pipe(
    mergeMap(params => this._defaultService.findById(+params['id'])),
  );

  avaliacoesRespostas = this._activedRoute.params.pipe(
    mergeMap(params => this._defaultService.findAllByAvaliacaoResolucaoLista(+params['id'], {})),
  );

  isRevision = false;

  constructor(
    private readonly _activedRoute: ActivatedRoute,
    private readonly _defaultService: RespostasService,
  ) {
  }

  ngOnInit() {
    const param = this._activedRoute.snapshot.params['id'];
  }

  toogleRevistion() {
    this.isRevision = !this.isRevision;
  }


}
