import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {

  @Input() title: string;
  @Input() class: string;
  @Input() date: Date;
  @Input() hasStatus = false;
  @Input() status: boolean;
  @Input() hasTagProfessor: boolean;
  @Input() statusProfessor: boolean;
  @Input() customIcon: string;

  constructor() {
  }

  ngOnInit() {
  }

}
