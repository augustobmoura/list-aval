import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {

  @Input() title: string
  @Input() class: string
  @Input() date: string
  @Input() hasStatus: boolean = false
  @Input() status: boolean
  @Input() hasTagProfessor: boolean
  @Input() statusProfessor: boolean

  constructor() { }

  ngOnInit() {
  }

  ngOnChanges(){

  }

}
