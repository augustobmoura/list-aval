import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StudentRoutingModule } from './student-routing.module';
import { StudentComponent } from './student/student.component';
import { SharedModule } from '../shared/shared.module';
import { MyListComponent } from './components/my-list/my-list.component';
import { RevisionComponent } from './components/revision/revision.component';

@NgModule({
  declarations: [StudentComponent, MyListComponent, RevisionComponent],
  imports: [
    CommonModule,
    StudentRoutingModule,
    SharedModule
  ]
})
export class StudentModule { }
