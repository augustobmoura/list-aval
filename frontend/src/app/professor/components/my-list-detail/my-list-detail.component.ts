import { Component, OnInit } from '@angular/core';
import { Resolucao } from 'src/app/core/models/aplicaoResolucao';
import { ResolucoesService } from 'src/app/core/services/resolucoes.service';
import { ActivatedRoute } from '@angular/router';
import { FormControl, FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-my-list-detail',
  templateUrl: './my-list-detail.component.html',
  styleUrls: ['./my-list-detail.component.scss']
})
export class MyListDetailComponent implements OnInit {

  comment = new FormControl('')
  nota = new FormControl('')
  aplicacaoListForm: FormGroup

  panels: any[] = []


  constructor(private resolucarService: ResolucoesService,
              private activedRoute: ActivatedRoute,
              private fb: FormBuilder) {
                this.aplicacaoListForm = fb.group({
                  lista: ['']
                })
  }

  ngOnInit() {
    this.resolucarService.getListaDetalhe(this.activedRoute.snapshot.params['id'])
      .subscribe((data) => {
        this.panels = data.content
        console.log(data)
      })
  }


}
