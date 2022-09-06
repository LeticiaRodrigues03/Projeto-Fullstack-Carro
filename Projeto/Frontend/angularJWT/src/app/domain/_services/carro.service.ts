import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Carro } from '@app/domain/_models/carro';
import { Observable } from 'rxjs';
import { FormBuilder } from '@angular/forms';

@Injectable({ providedIn: 'root' })
export class CarroService {

    constructor(private http: HttpClient) { }

    list() {
        return this.http.get<Carro[]>(`${environment.apiUrl}carro/list-carros`);
    }

    create(post: FormBuilder) {
        return this.http.post(`${environment.apiUrl}carro/add-carro`, post);
    }

}