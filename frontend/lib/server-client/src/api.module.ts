import { NgModule, ModuleWithProviders, SkipSelf, Optional } from '@angular/core';
import { Configuration } from './configuration';
import { HttpClient } from '@angular/common/http';


import { ApiAvaliacoesService } from './api/apiAvaliacoes.service';
import { ApiAvaliacoesIdService } from './api/apiAvaliacoesId.service';
import { ApiAvaliacoesIdDistribuaService } from './api/apiAvaliacoesIdDistribua.service';
import { ApiAvaliacoesResolucaoService } from './api/apiAvaliacoesResolucao.service';
import { ApiAvaliacoesResolucaoAvaliacaoResolucaoListaIdRespostaIdService } from './api/apiAvaliacoesResolucaoAvaliacaoResolucaoListaIdRespostaId.service';
import { ApiAvaliacoesResolucaoAvaliacaoResolucaoListaIdRespostasService } from './api/apiAvaliacoesResolucaoAvaliacaoResolucaoListaIdRespostas.service';
import { ApiAvaliacoesResolucaoIdService } from './api/apiAvaliacoesResolucaoId.service';
import { ApiAvaliacoesResolucaoMinhasService } from './api/apiAvaliacoesResolucaoMinhas.service';
import { ApiAvaliacoesResolucaoParaAvaliarService } from './api/apiAvaliacoesResolucaoParaAvaliar.service';
import { ApiAvaliacoesRespostaService } from './api/apiAvaliacoesResposta.service';
import { ApiAvaliacoesRespostaIdService } from './api/apiAvaliacoesRespostaId.service';
import { ApiResolucoesService } from './api/apiResolucoes.service';
import { ApiResolucoesIdService } from './api/apiResolucoesId.service';
import { ApiResolucoesResolucaoIdRespostasService } from './api/apiResolucoesResolucaoIdRespostas.service';
import { ApiRespostasService } from './api/apiRespostas.service';
import { ApiRespostasIdService } from './api/apiRespostasId.service';

@NgModule({
  imports:      [],
  declarations: [],
  exports:      [],
  providers: [
    ApiAvaliacoesService,
    ApiAvaliacoesIdService,
    ApiAvaliacoesIdDistribuaService,
    ApiAvaliacoesResolucaoService,
    ApiAvaliacoesResolucaoAvaliacaoResolucaoListaIdRespostaIdService,
    ApiAvaliacoesResolucaoAvaliacaoResolucaoListaIdRespostasService,
    ApiAvaliacoesResolucaoIdService,
    ApiAvaliacoesResolucaoMinhasService,
    ApiAvaliacoesResolucaoParaAvaliarService,
    ApiAvaliacoesRespostaService,
    ApiAvaliacoesRespostaIdService,
    ApiResolucoesService,
    ApiResolucoesIdService,
    ApiResolucoesResolucaoIdRespostasService,
    ApiRespostasService,
    ApiRespostasIdService ]
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
