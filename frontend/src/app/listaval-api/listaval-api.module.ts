import { ModuleWithProviders, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Configuration, DefaultService } from 'listaval-client/dist';


export const apiConfig: Configuration = new Configuration();

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
  ],
})
export class ListavalApiModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: ListavalApiModule,
      providers: [
        { provide: Configuration, useValue: apiConfig },
        DefaultService,
      ],
    };
  }
}
