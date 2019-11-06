import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import { EvaluatorRoutingModule } from './evaluator-routing.module';
import { EvaluatorMainComponent } from './pages/evaluator-main/evaluator-main.component';
import { SharedModule } from '../shared/shared.module';
import { AddListComponent } from './components/add-list/add-list.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FlexLayoutModule } from '@angular/flex-layout';

@NgModule({
  declarations: [EvaluatorMainComponent, AddListComponent],
  imports: [
    CommonModule,
    EvaluatorRoutingModule,
    SharedModule,
    NgxPaginationModule,
    FormsModule,
    ReactiveFormsModule,
    MatAutocompleteModule,
    MatFormFieldModule,
    MatInputModule,
    FlexLayoutModule
  ]
})
export class EvaluatorModule { }
