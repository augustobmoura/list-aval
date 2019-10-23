import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'panel-header',
  template: `
    <div class="title-panel">
      <ng-content></ng-content>
    </div>
  `,
})
export class PanelHeaderComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
