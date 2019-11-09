import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-rate-list-detail',
  templateUrl: './rate-list-detail.component.html',
  styleUrls: ['./rate-list-detail.component.scss']
})
export class RateListDetailComponent implements OnInit {

  panels: any[] = [
    {name: 'Questão 01', desc: 'Exemplo de Pergunta'},
    {name: 'Questão 02', desc: 'Exemplo de Pergunta'},
    {name: 'Questão 03', desc: 'Exemplo de Pergunta'},
    {name: 'Questão 04', desc: 'Exemplo de Pergunta'},
    {name: 'Questão 05', desc: 'Exemplo de Pergunta'},
  ]

  comment: FormControl
  nota: FormControl

  constructor() { }

  ngOnInit() {
  }

}
