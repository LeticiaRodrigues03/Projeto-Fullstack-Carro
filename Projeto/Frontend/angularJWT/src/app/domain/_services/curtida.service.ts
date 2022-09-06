import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Carro } from '@app/domain/_models/carro';
import { Observable } from 'rxjs';
import { FormBuilder } from '@angular/forms';

@Injectable({ providedIn: 'root' })
export class CurtidaService {

    constructor(private http: HttpClient) { }
    
    newCurtida(id: number): Observable<number> {
        return this.http.post<number>(`${environment.apiUrl}curtida/add-curtida`, id);
    }

    deleteCurtida(id: number): Observable<number> {
         return this.http.post<number>(`${environment.apiUrl}curtida/remover-curtida`, id);
    }

}