import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MyListComponent } from './components/my-list/my-list.component'
import { RevisionComponent } from './components/revision/revision.component';
import { StudentComponent } from './student/student.component';
import { MyListDetailComponent } from './components/my-list-detail/my-list-detail.component';

const routes: Routes = [
  {path: '', component: StudentComponent, children: [
    {path: '', redirectTo: 'minhas-listas', pathMatch: 'full'},
    {path: 'minhas-listas', component: MyListComponent},
    {path: 'detalhe-listas/:id', component: MyListDetailComponent},
    {path: 'revisao', component: RevisionComponent}
  ]},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }
