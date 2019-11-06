import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EvaluatorMainComponent } from './pages/evaluator-main/evaluator-main.component';
import { AddListComponent } from './components/add-list/add-list.component';

const routes: Routes = [
  {path: '', component: EvaluatorMainComponent, children: [
    {path: '', redirectTo: 'atribuir-listas', pathMatch: 'full'},
    {path: 'atribuir-listas', component: AddListComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EvaluatorRoutingModule { }
