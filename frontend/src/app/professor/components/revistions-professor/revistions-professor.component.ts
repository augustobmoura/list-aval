import { Component, OnInit } from '@angular/core';
import { listModel } from 'src/app/student/components/my-list/my-list.component';

@Component({
  selector: 'app-revistions-professor',
  templateUrl: './revistions-professor.component.html',
  styleUrls: ['./revistions-professor.component.scss']
})
export class RevistionsProfessorComponent implements OnInit {

  lists: listModel[] = []
  p: number = 1

  constructor() { }

  ngOnInit() {
    for(let i = 0; i < 25; i++){
      this.lists.push({
        title: `Engenharia de Software ${i}`,
        class: `Turma ${i}`,
        date: new Date(2019, 10, 15),
        id: i,
        publicado: i % 2 === 0 ? true : false
      })
    }

  }

  pageChanged($event){
    this.p = $event
  }

}
