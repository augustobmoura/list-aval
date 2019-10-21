import { Component, OnInit } from '@angular/core';

export interface listModel{
  title: string
  class: string
  date: string
}

@Component({
  selector: 'app-my-list',
  templateUrl: './my-list.component.html',
  styleUrls: ['./my-list.component.scss']
})
export class MyListComponent implements OnInit {

  lists: listModel[] = []
  p: number = 1

  constructor() { }

  ngOnInit() {
    for(let i = 0; i < 25; i++){
      this.lists.push({
        title: `Engenharia de Software ${i}`,
        class: `Turma ${i}`,
        date: '15/10/2019'
      })
    }

  }

  pageChanged($event){
    this.p = $event
  }

}
