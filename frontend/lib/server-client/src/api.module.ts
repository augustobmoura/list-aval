import { NgModule, ModuleWithProviders, SkipSelf, Optional } from '@angular/core';
import { Configuration } from './configuration';
import { HttpClient } from '@angular/common/http';


import { AvaliacoesService } from './api/avaliacoes.service';
import { AvaliacoesResolucaoService } from './api/avaliacoesResolucao.service';
import { AvaliacoesRespostaService } from './api/avaliacoesResposta.service';
import { DistribuaService } from './api/distribua.service';
import { IdService } from './api/id.service';
import { MinhasService } from './api/minhas.service';
import { ParaAvaliarService } from './api/paraAvaliar.service';
import { ResolucoesService } from './api/resolucoes.service';
import { RespostaIdService } from './api/respostaId.service';
import { RespostasService } from './api/respostas.service';

@NgModule({
  imports:      [],
  declarations: [],
  exports:      [],
  providers: [
    AvaliacoesService,
    AvaliacoesResolucaoService,
    AvaliacoesRespostaService,
    DistribuaService,
    IdService,
    MinhasService,
    ParaAvaliarService,
    ResolucoesService,
    RespostaIdService,
    RespostasService ]
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
