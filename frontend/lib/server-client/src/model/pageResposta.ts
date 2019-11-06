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
import { Resposta } from './resposta';
import { Pageable } from './pageable';
import { Sort } from './sort';


export interface PageResposta { 
    totalElements?: number;
    totalPages?: number;
    first?: boolean;
    sort?: Sort;
    number?: number;
    numberOfElements?: number;
    last?: boolean;
    pageable?: Pageable;
    size?: number;
    content?: Array<Resposta>;
    empty?: boolean;
}

