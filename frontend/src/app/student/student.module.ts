import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StudentRoutingModule } from './student-routing.module';
import { StudentComponent } from './student/student.component';
import { SharedModule } from '../shared/shared.module';
import { MyListComponent } from './components/my-list/my-list.component';
import { RevisionComponent } from './components/revision/revision.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { NgxPaginationModule } from 'ngx-pagination';
import { MyListDetailComponent } from './components/my-list-detail/my-list-detail.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MAT_LABEL_GLOBAL_OPTIONS } from '@angular/material/core';
import { MatInputModule } from '@angular/material/input';

@NgModule({
  declarations: [StudentComponent, MyListComponent, RevisionComponent, MyListDetailComponent],
  imports: [
    CommonModule,
    StudentRoutingModule,
    SharedModule,
    FlexLayoutModule,
    NgxPaginationModule,
    MatFormFieldModule,
    MatInputModule,
  ],
  providers: [
    { provide: MAT_LABEL_GLOBAL_OPTIONS, useValue: { float: 'always' } },
  ],
})
export class StudentModule {}
