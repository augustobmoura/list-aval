import { Component, OnInit } from '@angular/core';
import { listModel } from 'src/app/student/components/my-list/my-list.component';
import { ResolucoesService } from 'src/app/core/services/resolucoes.service';
import { Resolucao, ResolucaoItem } from 'src/app/core/models/aplicaoResolucao';

@Component({
  selector: 'app-my-list-professor',
  templateUrl: './my-list-professor.component.html',
  styleUrls: ['./my-list-professor.component.scss']
})
export class MyListProfessorComponent implements OnInit {

  lists: ResolucaoItem[] = []
  p: number = 1

  constructor(private resolucoesService: ResolucoesService) { }

  ngOnInit() {
    this.getResolucoes()
  }

  getResolucoes(){
    this.resolucoesService.getResolucoes()
      .subscribe((data: Resolucao) => {
        this.lists = data.content
        console.log(data)
      })
  }

  pageChanged($event){
    this.p = $event
  }

}
