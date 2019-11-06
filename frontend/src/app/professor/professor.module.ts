import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfessorRoutingModule } from './professor-routing.module';
import { ProfessorComponent } from './professor/professor.component';
import { MyListProfessorComponent } from './components/my-list-professor/my-list-professor.component';
import { MyListDetailComponent } from './components/my-list-detail/my-list-detail.component';
import { RevistionsProfessorComponent } from './components/revistions-professor/revistions-professor.component';
import { CoreModule } from '../core/core.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';
import { NgxPaginationModule } from 'ngx-pagination';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { StudentAnswerComponent } from './components/student-answer/student-answer.component';
import { RevisionDetailComponent } from './components/revision-detail/revision-detail.component';
import { StatisticsComponent } from './components/statistics/statistics.component';
import { StatisticsDetailComponent } from './components/statistics/statistics-detail/statistics-detail.component';
import { ChartsModule } from 'ng2-charts';
import {MatTableModule} from '@angular/material/table';
import { StatisticsStudentDetailComponent } from './components/statistics/statistics-student-detail/statistics-student-detail.component';
@NgModule({
  declarations: [ProfessorComponent, MyListProfessorComponent, MyListDetailComponent, RevistionsProfessorComponent, StudentAnswerComponent, RevisionDetailComponent, StatisticsComponent, StatisticsDetailComponent, StatisticsStudentDetailComponent],
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
    MatTableModule
  ]
})
export class ProfessorModule { }
