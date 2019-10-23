import { Component, OnInit } from '@angular/core';
import { NavItensModel } from 'src/app/shared/components/header/header.component';

@Component({
  selector: 'app-professor',
  templateUrl: './professor.component.html',
  styleUrls: ['./professor.component.scss']
})
export class ProfessorComponent implements OnInit {

  navItens: NavItensModel[] = [
    {link: '/professor/minhas-listas', name: 'Minhas Listas', icon: 'list'},
    {link: '/professor/revisoes', name: 'Revisões', icon: 'edit'},
  ]

  constructor() { }

  ngOnInit() {
  }

}
