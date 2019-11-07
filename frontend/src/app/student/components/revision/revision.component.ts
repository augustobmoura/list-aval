import { Component, OnInit } from '@angular/core';
import { listModel } from '../my-list/my-list.component';

export interface ListRevistionModel extends listModel {
  checked: boolean
}

@Component({
  selector: 'app-revision',
  templateUrl: './revision.component.html',
  styleUrls: ['./revision.component.scss']
})
export class RevisionComponent implements OnInit {

  lists: ListRevistionModel[] = [];
  p: number = 1;

  constructor() {
  }

  ngOnInit() {
    for (let i = 0; i < 25; i++) {
      this.lists.push({
        title: `Engenharia de Software ${i}`,
        class: `Turma ${i}`,
        date: new Date(2019, 10, 15),
        id: i,
        checked: i % 2 === 0 ? true : false
      });
    }
  }

  pageChanged($event) {
    this.p = $event;
  }

}
