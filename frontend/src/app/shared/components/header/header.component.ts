import { Component, OnInit, Input } from '@angular/core';
import {trigger, state, style, transition, animate} from '@angular/animations';
import { MediaObserver, MediaChange } from '@angular/flex-layout';
import { Subscription } from 'rxjs';

export interface NavItensModel{
  name: string,
  link: string,
  icon: string
}

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
  animations: [
    trigger('slideInOut', [
      state('in', style({
        transform: 'translate3d(0, 0, 0)'
      })),
      state('out', style({
        transform: 'translate3d(100%, 0, 0)'
      })),
      transition('in => out', animate('400ms ease-in-out')),
      transition('out => in', animate('400ms ease-in-out'))
    ]),
  ]
})
export class HeaderComponent implements OnInit {

  @Input() navItens: NavItensModel
  menuState:string
  isMobile: boolean = false
  watcher: Subscription;
  activeMediaQuery = '';

  constructor(mediaObserver: MediaObserver) {
    this.watcher = mediaObserver.media$.subscribe((change: MediaChange) => {
      this.activeMediaQuery = change ? `'${change.mqAlias}' = (${change.mediaQuery})` : '';
      this.isMobile = change.mqAlias == 'xs' || change.mqAlias == 'sm'
      this.isMobile ? this.menuState = 'out' : this.menuState = 'void'
    });

  }

  toggleMenu() {
      if(this.isMobile){
        this.menuState = this.menuState === 'out' ? 'in' : 'out';
      }
  }


  ngOnInit() {
  }

  ngOnDestroy() {
    this.watcher.unsubscribe();
  }





}
