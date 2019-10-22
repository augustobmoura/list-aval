import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfessorComponent } from './professor/professor.component';
import { MyListProfessorComponent } from './components/my-list-professor/my-list-professor.component';
import { MyListDetailComponent } from './components/my-list-detail/my-list-detail.component';
import { RevistionsProfessorComponent } from './components/revistions-professor/revistions-professor.component';
import { RevisionDetailComponent } from './components/revision-detail/revision-detail.component';

const routes: Routes = [
  {path: '', component: ProfessorComponent, children: [
    {path: '', redirectTo: 'minhas-listas', pathMatch: 'full'},
    {path: 'minhas-listas', component: MyListProfessorComponent },
    {path: 'revisoes', component: RevistionsProfessorComponent},
    {path: 'lista-detalhe/:id', component: MyListDetailComponent},
    {path: 'revisao-detalhe/:id', component: RevisionDetailComponent},
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfessorRoutingModule { }
