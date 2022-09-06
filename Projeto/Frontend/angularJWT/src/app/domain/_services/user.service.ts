import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { User } from '../_models';
import { FormBuilder } from '@angular/forms';

@Injectable({ providedIn: 'root' })
export class UserService {

    apiUrl = 'http://localhost:8080/user';

    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<User[]>(`${environment.apiUrl}/user`);
    }
    
    createUser(post: FormBuilder) {
        return this.http.post(`${environment.apiUrl}user/sign-up`, post);
    }
    
}