import { Component, OnInit } from '@angular/core';
import { ChartOptions, ChartDataSets, ChartType } from 'chart.js';
import { Label, Color } from 'ng2-charts';

export interface PeriodicElement {
  id: number;
  name: string;
  matricula: string
  cpf: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  { id: 1, name: 'Exemplo Nome Aluno', matricula: "20142222", cpf: '000.000.000-00'},
  { id: 1, name: 'Exemplo Nome Aluno', matricula: "20142222", cpf: '000.000.000-00'},
  { id: 1, name: 'Exemplo Nome Aluno', matricula: "20142222", cpf: '000.000.000-00'},
  { id: 1, name: 'Exemplo Nome Aluno', matricula: "20142222", cpf: '000.000.000-00'},
  { id: 1, name: 'Exemplo Nome Aluno', matricula: "20142222", cpf: '000.000.000-00'},
  { id: 1, name: 'Exemplo Nome Aluno', matricula: "20142222", cpf: '000.000.000-00'},
  { id: 1, name: 'Exemplo Nome Aluno', matricula: "20142222", cpf: '000.000.000-00'},
  { id: 1, name: 'Exemplo Nome Aluno', matricula: "20142222", cpf: '000.000.000-00'},
  { id: 1, name: 'Exemplo Nome Aluno', matricula: "20142222", cpf: '000.000.000-00'},
  { id: 1, name: 'Exemplo Nome Aluno', matricula: "20142222", cpf: '000.000.000-00'},
  { id: 1, name: 'Exemplo Nome Aluno', matricula: "20142222", cpf: '000.000.000-00'},
  { id: 1, name: 'Exemplo Nome Aluno', matricula: "20142222", cpf: '000.000.000-00'},
];


@Component({
  selector: 'app-statistics-detail',
  templateUrl: './statistics-detail.component.html',
  styleUrls: ['./statistics-detail.component.scss']
})
export class StatisticsDetailComponent implements OnInit {

  displayedColumns: string[] = ['name', 'cpf', 'matricula', 'acoes'];
  dataSource = ELEMENT_DATA;

  public barChartOptions: ChartOptions = {
    responsive: true,
    // We use these empty structures as placeholders for dynamic theming.
    scales: { xAxes: [{}], yAxes: [{}] },
    plugins: {
      datalabels: {
        anchor: 'end',
        align: 'end',
      }
    }
  };
  public barChartLabels: Label[] = ['Questão 1', 'Questão 2', 'Questão 3', 'Questão 4', 'Questão 5', 'Questão 6'];
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;
  public barChartPlugins = [];

  public colorScheme

  public chartColors: Array<any> = [
    {
      backgroundColor: []
    }
  ]

  public barChartData: ChartDataSets[] = [
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'Estástica Turma' }
  ];

  constructor() { }

  ngOnInit() {
    for (let i  = 0; i < this.barChartLabels.length; i++){
      this.chartColors[0].backgroundColor.push('rgba(163, 160, 251,0.6)')
    }
  }

}
