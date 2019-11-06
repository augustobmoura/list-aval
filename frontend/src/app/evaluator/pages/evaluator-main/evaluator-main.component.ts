import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-evaluator-main',
  templateUrl: './evaluator-main.component.html',
  styleUrls: ['./evaluator-main.component.scss']
})
export class EvaluatorMainComponent implements OnInit {

  public navItens: any[] = []

  constructor() { }

  ngOnInit() {
    this.navItens = [
      {link: '/avaliador/atribuir-listas', name: 'Atribuir à lista', icon: 'list'}
    ]
  }

}
