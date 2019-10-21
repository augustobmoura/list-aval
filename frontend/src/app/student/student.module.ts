import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StudentRoutingModule } from './student-routing.module';
import { StudentComponent } from './student/student.component';
import { SharedModule } from '../shared/shared.module';
import { MyListComponent } from './components/my-list/my-list.component';
import { RevisionComponent } from './components/revision/revision.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({
  declarations: [StudentComponent, MyListComponent, RevisionComponent],
  imports: [
    CommonModule,
    StudentRoutingModule,
    SharedModule,
    FlexLayoutModule,
    NgxPaginationModule
  ]
})
export class StudentModule { }
