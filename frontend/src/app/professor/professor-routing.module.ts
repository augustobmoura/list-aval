import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfessorComponent } from './professor/professor.component';
import { MyListProfessorComponent } from './components/my-list-professor/my-list-professor.component';
import { MyListDetailComponent } from './components/my-list-detail/my-list-detail.component';
import { RevistionsProfessorComponent } from './components/revistions-professor/revistions-professor.component';
import { RevisionDetailComponent } from './components/revision-detail/revision-detail.component';
import { StatisticsComponent } from './components/statistics/statistics.component';
import { StatisticsDetailComponent } from './components/statistics/statistics-detail/statistics-detail.component';
import { StatisticsStudentDetailComponent } from './components/statistics/statistics-student-detail/statistics-student-detail.component';
import { EvaluatorMainComponent } from './components/evaluator-main/evaluator-main.component';
import { AddListComponent } from './components/add-list/add-list.component';

const routes: Routes = [
  {path: '', component: ProfessorComponent, children: [
    {path: '', redirectTo: 'minhas-listas', pathMatch: 'full'},
    {path: 'minhas-listas', component: MyListProfessorComponent },
    {path: 'revisoes', component: RevistionsProfessorComponent},
    {path: 'lista-detalhe/:id', component: MyListDetailComponent},
    {path: 'revisao-detalhe/:id', component: RevisionDetailComponent},
    {path: 'estatisticas', component: StatisticsComponent},
    {path: 'estatisticas-detalhe/:id', component: StatisticsDetailComponent},
    {path: 'estatisticas-detalhe/aluno/:id', component: StatisticsStudentDetailComponent},
    {path: 'atribuir-lista', component: AddListComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfessorRoutingModule { }
