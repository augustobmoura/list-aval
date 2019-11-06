import { ModuleWithProviders, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Configuration, DefaultService } from '../../../lib/server-client/src';
import { HttpClientModule } from '@angular/common/http';


export const apiConfig: Configuration = new Configuration({ basePath: '' });

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    HttpClientModule,
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
