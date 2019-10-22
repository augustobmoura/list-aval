import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-my-list-detail',
  templateUrl: './my-list-detail.component.html',
  styleUrls: ['./my-list-detail.component.scss']
})
export class MyListDetailComponent implements OnInit {

  panels: any[] = [
    {name: 'Questão 01', desc: 'Exemplo de Pergunta'},
    {name: 'Questão 02', desc: 'Exemplo de Pergunta'},
    {name: 'Questão 03', desc: 'Exemplo de Pergunta'},
    {name: 'Questão 04', desc: 'Exemplo de Pergunta'},
    {name: 'Questão 05', desc: 'Exemplo de Pergunta'},
  ]

  isRevision: boolean = false;

  constructor() { }

  ngOnInit() {
  }

  toogleRevistion(){
    this.isRevision = !this.isRevision
  }



}
