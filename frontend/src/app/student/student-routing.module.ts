import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MyListDetailComponent } from './components/my-list-detail/my-list-detail.component';
import { MyListComponent } from './components/my-list/my-list.component';
import { RateListDetailComponent } from './components/rate-list/rate-list-detail/rate-list-detail.component';
import { RateListComponent } from './components/rate-list/rate-list.component';
import { RevisionComponent } from './components/revision/revision.component';
import { StudentComponent } from './student/student.component';

const routes: Routes = [
  {
    path: '', component: StudentComponent, children: [
      { path: '', redirectTo: 'minhas-listas', pathMatch: 'full' },
      { path: 'minhas-listas', component: MyListComponent },
      { path: 'listas-para-avaliar', component: RateListComponent },
      { path: 'listas-para-avaliar/:id', component: RateListDetailComponent },
      { path: 'detalhe-listas/:id', component: MyListDetailComponent },
      { path: 'revisao', component: RevisionComponent },
    ]
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule {
}
