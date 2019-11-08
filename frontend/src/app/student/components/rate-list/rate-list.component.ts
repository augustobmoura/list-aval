import { Component, OnInit } from '@angular/core';
import { listModel } from '../my-list/my-list.component';

@Component({
  selector: 'app-rate-list',
  templateUrl: './rate-list.component.html',
  styleUrls: ['./rate-list.component.scss']
})
export class RateListComponent implements OnInit {

  lists: any[] = []
  p: number = 1

  constructor() { }

  ngOnInit() {
    for(let i = 0; i < 25; i++){
      this.lists.push({
        title: `Engenharia de Software ${i}`,
        class: `Professor Joe Doe`,
        date: '2019-11-04T03:54:41.804773',
        id: i,
        publicado: i % 2 === 0 ? true : false
      })
    }
  }

  pageChanged($event){
    this.p = $event
  }

}
