export * from './apiAvaliacoes.service';
import { ApiAvaliacoesService } from './apiAvaliacoes.service';
import { ApiAvaliacoesResolucaoService } from './apiAvaliacoesResolucao.service';
import { ApiAvaliacoesRespostaService } from './apiAvaliacoesResposta.service';
import { ApiLoginService } from './apiLogin.service';
import { ApiResolucoesService } from './apiResolucoes.service';
import { ApiRespostasService } from './apiRespostas.service';

export * from './apiAvaliacoesResolucao.service';
export * from './apiAvaliacoesResposta.service';
export * from './apiLogin.service';
export * from './apiResolucoes.service';
export * from './apiRespostas.service';
export const APIS = [
  ApiAvaliacoesService,
  ApiAvaliacoesResolucaoService,
  ApiAvaliacoesRespostaService,
  ApiLoginService,
  ApiResolucoesService,
  ApiRespostasService,
];
