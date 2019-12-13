import { NgModule, ModuleWithProviders, SkipSelf, Optional } from '@angular/core';
import { Configuration } from './configuration';
import { HttpClient } from '@angular/common/http';


import { ApiAvaliacoesService } from './api/apiAvaliacoes.service';
import { ApiAvaliacoesResolucaoService } from './api/apiAvaliacoesResolucao.service';
import { ApiAvaliacoesRespostaService } from './api/apiAvaliacoesResposta.service';
import { ApiLoginService } from './api/apiLogin.service';
import { ApiResolucoesService } from './api/apiResolucoes.service';
import { ApiRespostasService } from './api/apiRespostas.service';

@NgModule({
  imports:      [],
  declarations: [],
  exports:      [],
  providers: [
    ApiAvaliacoesService,
    ApiAvaliacoesResolucaoService,
    ApiAvaliacoesRespostaService,
    ApiLoginService,
    ApiResolucoesService,
    ApiRespostasService ]
})
export class ApiModule {
    public static forRoot(configurationFactory: () => Configuration): ModuleWithProviders {
        return {
            ngModule: ApiModule,
            providers: [ { provide: Configuration, useFactory: configurationFactory } ]
        };
    }

    constructor( @Optional() @SkipSelf() parentModule: ApiModule,
                 @Optional() http: HttpClient) {
        if (parentModule) {
            throw new Error('ApiModule is already loaded. Import in your base AppModule only.');
        }
        if (!http) {
            throw new Error('You need to import the HttpClientModule in your AppModule! \n' +
            'See also https://github.com/angular/angular/issues/20575');
        }
    }
}
