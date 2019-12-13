export * from './apiAvaliacoes.service';
import { ApiAvaliacoesService } from './apiAvaliacoes.service';
export * from './apiAvaliacoesResolucao.service';
import { ApiAvaliacoesResolucaoService } from './apiAvaliacoesResolucao.service';
export * from './apiAvaliacoesResposta.service';
import { ApiAvaliacoesRespostaService } from './apiAvaliacoesResposta.service';
export * from './apiLogin.service';
import { ApiLoginService } from './apiLogin.service';
export * from './apiResolucoes.service';
import { ApiResolucoesService } from './apiResolucoes.service';
export * from './apiRespostas.service';
import { ApiRespostasService } from './apiRespostas.service';
export const APIS = [ApiAvaliacoesService, ApiAvaliacoesResolucaoService, ApiAvaliacoesRespostaService, ApiLoginService, ApiResolucoesService, ApiRespostasService];
