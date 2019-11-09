import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { ChartsModule } from 'ng2-charts';
import { NgxPaginationModule } from 'ngx-pagination';
import { CoreModule } from '../core/core.module';
import { SharedModule } from '../shared/shared.module';
import { AddListComponent } from './components/add-list/add-list.component';
import { EvaluatorMainComponent } from './components/evaluator-main/evaluator-main.component';
import { MyListDetailComponent } from './components/my-list-detail/my-list-detail.component';
import { MyListProfessorComponent } from './components/my-list-professor/my-list-professor.component';
import { RevisionDetailComponent } from './components/revision-detail/revision-detail.component';
import { RevistionsProfessorComponent } from './components/revistions-professor/revistions-professor.component';
import { StatisticsDetailComponent } from './components/statistics/statistics-detail/statistics-detail.component';
import { StatisticsStudentDetailComponent } from './components/statistics/statistics-student-detail/statistics-student-detail.component';
import { StatisticsComponent } from './components/statistics/statistics.component';
import { StudentAnswerComponent } from './components/student-answer/student-answer.component';

import { ProfessorRoutingModule } from './professor-routing.module';
import { ProfessorComponent } from './professor/professor.component';

@NgModule({
  declarations: [
    EvaluatorMainComponent,
    AddListComponent, ProfessorComponent, MyListProfessorComponent, MyListDetailComponent, RevistionsProfessorComponent, StudentAnswerComponent, RevisionDetailComponent, StatisticsComponent, StatisticsDetailComponent, StatisticsStudentDetailComponent],
  imports: [
    CommonModule,
    ProfessorRoutingModule,
    CoreModule,
    FlexLayoutModule,
    ReactiveFormsModule,
    FormsModule,
    SharedModule,
    NgxPaginationModule,
    MatFormFieldModule,
    MatInputModule,
    ChartsModule,
    MatTableModule,
    MatAutocompleteModule
  ]
})
export class ProfessorModule {
}
