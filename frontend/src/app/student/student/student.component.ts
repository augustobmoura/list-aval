import { Component, OnInit } from '@angular/core';
import { NavItensModel } from 'src/app/shared/components/header/header.component';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.scss']
})
export class StudentComponent implements OnInit {

  navItens: NavItensModel[] = [
    {link: '/aluno/minhas-listas', name: 'Minhas Listas', icon: 'list'},
    {link: '/aluno/revisao', name: 'Revisões', icon: 'edit'},
  ]

  constructor() { }

  ngOnInit() {
  }

}
