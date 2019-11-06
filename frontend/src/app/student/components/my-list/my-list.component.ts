import { Component } from '@angular/core';
import { DefaultService } from '../../../../../lib/server-client/src';
import { map } from 'rxjs/operators';

export interface listModel {
  title: string
  class: string
  date: string
  id: number
  publicado?: boolean
}


@Component({
  selector: 'app-my-list',
  templateUrl: './my-list.component.html',
  styleUrls: ['./my-list.component.scss'],
})
export class MyListComponent {

  lists: Promise<unknown[]> = this._defaultService.findAll4({}).pipe(
    map(it => it.content),
  ).toPromise();

  constructor(
    private readonly _defaultService: DefaultService,
  ) {
  }

}
