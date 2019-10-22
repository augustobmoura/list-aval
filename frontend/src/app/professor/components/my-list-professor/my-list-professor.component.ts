import { Component, OnInit } from '@angular/core';
import { listModel } from 'src/app/student/components/my-list/my-list.component';

@Component({
  selector: 'app-my-list-professor',
  templateUrl: './my-list-professor.component.html',
  styleUrls: ['./my-list-professor.component.scss']
})
export class MyListProfessorComponent implements OnInit {

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

  pageChanged($event){
    this.p = $event
  }

}
