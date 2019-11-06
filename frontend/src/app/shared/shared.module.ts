import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { RouterModule } from '@angular/router';
import { CardComponent } from './components/card/card.component';
import { PanelHeaderComponent } from './components/accordion-component/panel/panel-header/panel-header.component';
import { AccordionComponent } from './components/accordion-component/accordion-component.component';
import { AccordionGroupComponent } from './components/accordion-component/panel/panel.component';
import { AccordionOptionsDirective } from './components/accordion-component/accordion-directives';
import { NavBackComponent } from './components/nav-back/nav-back.component';
import { ModalComponent } from './components/modal/modal.component';

@NgModule({
  declarations: [HeaderComponent, AccordionOptionsDirective, CardComponent, AccordionComponent, AccordionGroupComponent, PanelHeaderComponent, NavBackComponent, ModalComponent],
  imports: [
    CommonModule,
    FlexLayoutModule,
    RouterModule
  ],
  exports: [HeaderComponent, ModalComponent, NavBackComponent, AccordionOptionsDirective, CardComponent, AccordionComponent, AccordionGroupComponent, PanelHeaderComponent]
})
export class SharedModule { }
