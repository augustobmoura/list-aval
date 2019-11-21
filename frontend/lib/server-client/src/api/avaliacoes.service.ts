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

import { AvaliacaoLista } from '../model/avaliacaoLista';
import { PageAvaliacaoLista } from '../model/pageAvaliacaoLista';
import { Pageable } from '../model/pageable';

import { BASE_PATH, COLLECTION_FORMATS }                     from '../variables';
import { Configuration }                                     from '../configuration';


@Injectable({
  providedIn: 'root'
})
export class AvaliacoesService {

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
     * @param avaliacaoLista 
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public create2(avaliacaoLista?: AvaliacaoLista, observe?: 'body', reportProgress?: boolean): Observable<AvaliacaoLista>;
    public create2(avaliacaoLista?: AvaliacaoLista, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<AvaliacaoLista>>;
    public create2(avaliacaoLista?: AvaliacaoLista, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<AvaliacaoLista>>;
    public create2(avaliacaoLista?: AvaliacaoLista, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        let headers = this.defaultHeaders;

        // to determine the Accept header
        const httpHeaderAccepts: string[] = [
            '*/*'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected !== undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }


        // to determine the Content-Type header
        const consumes: string[] = [
        ];
        const httpContentTypeSelected: string | undefined = this.configuration.selectHeaderContentType(consumes);
        if (httpContentTypeSelected !== undefined) {
            headers = headers.set('Content-Type', httpContentTypeSelected);
        }

        return this.httpClient.post<AvaliacaoLista>(`${this.configuration.basePath}/api/avaliacoes`,
            avaliacaoLista,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * @param pageable 
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public findAll4(pageable?: Pageable, observe?: 'body', reportProgress?: boolean): Observable<PageAvaliacaoLista>;
    public findAll4(pageable?: Pageable, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<PageAvaliacaoLista>>;
    public findAll4(pageable?: Pageable, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<PageAvaliacaoLista>>;
    public findAll4(pageable?: Pageable, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        let queryParameters = new HttpParams({encoder: this.encoder});
        if (pageable !== undefined && pageable !== null) {
            queryParameters = queryParameters.set('pageable', <any>pageable);
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


        return this.httpClient.get<PageAvaliacaoLista>(`${this.configuration.basePath}/api/avaliacoes`,
            {
                params: queryParameters,
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

}
