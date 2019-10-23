import { Component, OnInit, Input } from '@angular/core';
import { Location } from '@angular/common';

@Component({
  selector: 'app-nav-back',
  templateUrl: './nav-back.component.html',
  styleUrls: ['./nav-back.component.scss']
})
export class NavBackComponent implements OnInit {

  @Input() title: string

  constructor(private location: Location) { }

  ngOnInit() {
  }

  back(){
    this.location.back()
  }

}
