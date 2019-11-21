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
/* tslint:disable:no-unused-variable member-ordering */

import { Inject, Injectable, Optional }                      from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams,
         HttpResponse, HttpEvent, HttpParameterCodec }       from '@angular/common/http';
import { CustomHttpParameterCodec }                          from '../encoder';
import { Observable }                                        from 'rxjs';

import { AvaliacaoResposta } from '../model/avaliacaoResposta';

import { BASE_PATH, COLLECTION_FORMATS }                     from '../variables';
import { Configuration }                                     from '../configuration';


@Injectable({
  providedIn: 'root'
})
export class RespostaIdService {

    protected basePath = 'https://evening-harbor-96341.herokuapp.com';
    public defaultHeaders = new HttpHeaders();
    public configuration = new Configuration();
    public encoder: HttpParameterCodec;

    constructor(protected httpClient: HttpClient, @Optional()@Inject(BASE_PATH) basePath: string, @Optional() configuration: Configuration) {
        if (configuration) {
            this.configuration = configuration;
        }
        if (typeof this.configuration.basePath !== 'string') {
            if (typeof basePath !== 'string') {
                basePath = this.basePath;
            }
            this.configuration.basePath = basePath;
        }
        this.encoder = this.configuration.encoder || new CustomHttpParameterCodec();
    }



    /**
     * @param avaliacaoResolucaoListaId 
     * @param respostaId 
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public findByAvaliacaoResolucaoListaAndResposta(avaliacaoResolucaoListaId: number, respostaId: number, observe?: 'body', reportProgress?: boolean): Observable<AvaliacaoResposta>;
    public findByAvaliacaoResolucaoListaAndResposta(avaliacaoResolucaoListaId: number, respostaId: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<AvaliacaoResposta>>;
    public findByAvaliacaoResolucaoListaAndResposta(avaliacaoResolucaoListaId: number, respostaId: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<AvaliacaoResposta>>;
    public findByAvaliacaoResolucaoListaAndResposta(avaliacaoResolucaoListaId: number, respostaId: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {
        if (avaliacaoResolucaoListaId === null || avaliacaoResolucaoListaId === undefined) {
            throw new Error('Required parameter avaliacaoResolucaoListaId was null or undefined when calling findByAvaliacaoResolucaoListaAndResposta.');
        }
        if (respostaId === null || respostaId === undefined) {
            throw new Error('Required parameter respostaId was null or undefined when calling findByAvaliacaoResolucaoListaAndResposta.');
        }

        let headers = this.defaultHeaders;

        // to determine the Accept header
        const httpHeaderAccepts: string[] = [
            '*/*'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected !== undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }


        return this.httpClient.get<AvaliacaoResposta>(`${this.configuration.basePath}/api/avaliacoesResolucao/${encodeURIComponent(String(avaliacaoResolucaoListaId))}/${encodeURIComponent(String(respostaId))}`,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

}
