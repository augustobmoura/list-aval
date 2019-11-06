import { Component, OnInit } from '@angular/core';
import { listModel } from 'src/app/student/components/my-list/my-list.component';

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.scss']
})
export class StatisticsComponent implements OnInit {

  lists: listModel[] = []
  p: number = 1

  constructor() { }

  ngOnInit() {
    for(let i = 0; i < 25; i++){
      this.lists.push({
        title: `Engenharia de Software ${i}`,
        class: `Turma ${i}`,
        date: '15/10/2019',
        id: i,
        publicado: i % 2 === 0 ? true : false
      })
    }
  }

}
