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
import { Pageable } from './pageable';
import { Sort } from './sort';
import { AvaliacaoResolucaoLista } from './avaliacaoResolucaoLista';


export interface PageAvaliacaoResolucaoLista { 
    totalPages?: number;
    totalElements?: number;
    number?: number;
    size?: number;
    numberOfElements?: number;
    content?: Array<AvaliacaoResolucaoLista>;
    sort?: Sort;
    first?: boolean;
    last?: boolean;
    pageable?: Pageable;
    empty?: boolean;
}

