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
import { Questao } from './questao';


export interface Lista {
  id?: number;
  questoes?: Array<Questao>;
  dataCadastro?: Date;
  usuarioCadastro?: string;
  dataAlteracao?: Date;
  usuarioAlteracao?: string;
}

