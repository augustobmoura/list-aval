import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { RouterModule } from '@angular/router';
import { CardComponent } from './components/card/card.component';

@NgModule({
  declarations: [HeaderComponent, CardComponent],
  imports: [
    CommonModule,
    FlexLayoutModule,
    RouterModule
  ],
  exports: [HeaderComponent, CardComponent]
})
export class SharedModule { }
