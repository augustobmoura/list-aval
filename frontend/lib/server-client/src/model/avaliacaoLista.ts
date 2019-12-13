/**
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


export interface AvaliacaoLista {
  id?: number;
  aplicacaoListaId: string;
  avaliadores?: Array<string>;
  criterioAvaliacao: AvaliacaoLista.CriterioAvaliacaoEnum;
  distribuida: boolean;
  dataCadastro?: Date;
  usuarioCadastro?: string;
  dataAlteracao?: Date;
  usuarioAlteracao?: string;
}
export namespace AvaliacaoLista {
    export type CriterioAvaliacaoEnum = 'MESA_REDONDA' | 'FIFO' | 'RANDOMICO';
    export const CriterioAvaliacaoEnum = {
        MESAREDONDA: 'MESA_REDONDA' as CriterioAvaliacaoEnum,
        FIFO: 'FIFO' as CriterioAvaliacaoEnum,
        RANDOMICO: 'RANDOMICO' as CriterioAvaliacaoEnum
    };
}


