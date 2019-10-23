import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-revision-detail',
  templateUrl: './revision-detail.component.html',
  styleUrls: ['./revision-detail.component.scss']
})
export class RevisionDetailComponent implements OnInit {

  panels: any[] = [
    {name: 'Questão 01', desc: 'Exemplo de Pergunta'},
    {name: 'Questão 02', desc: 'Exemplo de Pergunta'},
    {name: 'Questão 03', desc: 'Exemplo de Pergunta'},
    {name: 'Questão 04', desc: 'Exemplo de Pergunta'},
    {name: 'Questão 05', desc: 'Exemplo de Pergunta'},
  ]

  constructor() { }

  ngOnInit() {
  }



}
