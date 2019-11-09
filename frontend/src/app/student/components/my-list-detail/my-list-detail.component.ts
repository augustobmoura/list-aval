import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { mergeMap } from 'rxjs/operators';
import { DefaultService } from '../../../../../lib/server-client/src';

@Component({
  selector: 'app-my-list-detail',
  templateUrl: './my-list-detail.component.html',
  styleUrls: ['./my-list-detail.component.scss']
})
export class MyListDetailComponent implements OnInit {

  avaliacao = this._activedRoute.params.pipe(
    mergeMap(params => this._defaultService.findById1(+params['id'])),
  );

  avaliacoesRespostas = this._activedRoute.params.pipe(
    mergeMap(params => this._defaultService.findAllByAvaliacaoResolucaoLista(+params['id'], {})),
  );

  isRevision = false;

  constructor(
    private readonly _activedRoute: ActivatedRoute,
    private readonly _defaultService: DefaultService,
  ) {
  }

  ngOnInit() {
    const param = this._activedRoute.snapshot.params['id'];
  }

  toogleRevistion() {
    this.isRevision = !this.isRevision;
  }


}
