import {Component, Input, OnInit} from '@angular/core';
import {animate, state, style, transition, trigger, query, stagger, animateChild} from '@angular/animations';

@Component({
  selector: 'modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.scss'],
  animations: [
    trigger('modalAnimation', [
      state('opened', style({
          transform: 'translateY(0)',
        }
        )
      ),
      state('closed', style({
          transform: 'translateY(-200%)',
        }
        )
      ),
      transition('closed => opened', [
        animate('200ms ease-out')
      ]),
      transition('opened => closed', [
        animate('200ms ease-in')
      ]),
      transition(':enter', [
        query(':self', [
          style({opacity: 0, transform: 'translateY(200%)'}),
          animate('200ms ease-out', style({opacity: 1, transform: 'translateY(0)'}))
        ])
      ]),
      transition(':leave', [
        query(':self', [
          animate('200ms ease-in', style({transform: 'translateY(-200%)'}))
        ])
      ])
    ]),
    trigger('backgroundAnimation', [
      state('opened', style({opacity: 1})),
      state('closed', style({opacity: 0})),
      transition('closed => opened', [
        animate('200ms ease-out')
      ]),
      transition('opened => closed', [
        animate('200ms ease-in')
      ]),
      transition(':enter', [
        query(':self, @modalAnimation', [
          stagger(100, [
            animateChild(),
            animate('200ms ease-out', style({opacity: 1}))
          ])
        ])
      ]),
      transition(':leave', [
        query(':self, @modalAnimation', [
          stagger(100, [
            animateChild(),
            animate('300ms ease-in', style({opacity: 0})),
          ])
        ])
      ])
    ])
  ]
})
export class ModalComponent implements OnInit {
  @Input() autoOpen = false;
  private _opened = false;
  constructor() { }

  ngOnInit() {
    if (this.autoOpen) {this._opened = true; }
  }

  get opened() {return this._opened; }

  public open() { this._opened = true; }

  public close() { this._opened = false; }

  public switch() { this._opened = !this._opened; }

}
