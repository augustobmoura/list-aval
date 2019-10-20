import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path: '', redirectTo: 'aluno', pathMatch: 'full'},
  {path: 'aluno', loadChildren: () => import('./student/student.module').then(m => m.StudentModule)},
  {path: 'professor', loadChildren: () => import('./professor/professor.module').then(m => m.ProfessorModule)},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

 }
