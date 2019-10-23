import {Component, ContentChildren, QueryList, AfterContentInit } from "@angular/core";
import { AccordionGroupComponent } from './panel/panel.component';

@Component({
  selector: "accordion",
  template: `
    <ng-content></ng-content>
  `
})

export class AccordionComponent implements AfterContentInit {

  @ContentChildren(AccordionGroupComponent) panels: QueryList<AccordionGroupComponent>;

  ngAfterContentInit() {
    this.panels.toArray().forEach(p => {
      p.toggle.subscribe(() => {
        this.openGroup(p);
      });
    });
  }

  openGroup(group: any){
    const defaultHeight = group.panel.nativeElement.offsetHeight + 'px';
    if(group.opened){
      group.opened = false;
      group.panelContainer.nativeElement.style.height = 0 + 'px'
    } else{
      this.panels.toArray().forEach(t => {
        t.opened = false;
        t.panelContainer.nativeElement.style.height = 0 + 'px'
      });
      group.opened = true;
      group.panelContainer.nativeElement.style.height = defaultHeight
    }
  }
}