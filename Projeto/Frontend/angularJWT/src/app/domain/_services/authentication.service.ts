import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';



import { environment } from 'src/environments/environment';
import { User } from '../_models';
import { FormBuilder } from '@angular/forms';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {

    private currentUserSubject: BehaviorSubject<User>;
    private accessTokenSubject: BehaviorSubject<String>;
    public currentUserObservable: Observable<User>;
    public accessTokenObservable: Observable<String>;

    constructor(private http: HttpClient) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')!));
        this.accessTokenSubject = new BehaviorSubject<String>(JSON.parse(localStorage.getItem('accessToken')!));
        this.currentUserObservable = this.currentUserSubject.asObservable();
        this.accessTokenObservable = this.accessTokenSubject.asObservable();
    }

    public get currentUser(): User {
        return this.currentUserSubject.value;
    }

    public get accessToken(): String {
        return this.accessTokenSubject.value;
    }

    login(username: string, password: string) {
        return this.http.post<any>(`${environment.apiUrl}api/login`, { username, password })
            .pipe(map(data => {
                // store user details and jwt token in local storage to keep user logged in between page refreshes
                localStorage.setItem('currentUser', JSON.stringify(data.me));
                this.currentUserSubject.next(data.me);
                localStorage.setItem('accessToken', JSON.stringify(data.access_token));
                this.accessTokenSubject.next(data.access_token);

                return true;
            }));
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null);
        localStorage.removeItem('accessToken');
        this.accessTokenSubject.next(null);
    }

    getCurrentUser() {
        return this.http.get<User>(`${environment.apiUrl}user/get-current-user`);
    }


}