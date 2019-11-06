import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Resolucao } from '../models/aplicaoResolucao';

@Injectable({
  providedIn: 'root'
})
export class ResolucoesService {

  constructor(private http: HttpClient) { }

  getResolucoes() : Observable<Resolucao>{
    return this.http.get<Resolucao>(`${environment.url}api/resolucoes`)
  }

  getListaDetalhe(id): Observable<any>{
    return this.http.get(`${environment.url}api/resolucoes/${id}/respostas`)
  }
}
