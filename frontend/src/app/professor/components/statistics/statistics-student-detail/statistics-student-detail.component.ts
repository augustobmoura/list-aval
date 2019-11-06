import { Component, OnInit } from '@angular/core';
import { ChartOptions, ChartDataSets, ChartType } from 'chart.js';
import { Label, Color } from 'ng2-charts';

@Component({
  selector: 'app-statistics-student-detail',
  templateUrl: './statistics-student-detail.component.html',
  styleUrls: ['./statistics-student-detail.component.scss']
})
export class StatisticsStudentDetailComponent implements OnInit {

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
