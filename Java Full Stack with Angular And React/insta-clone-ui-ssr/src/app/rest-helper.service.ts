import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ILoginForm, IRegisterForm } from './Interfaces/instaclone';

@Injectable()

export class RestHelperService {
  private baseUrl: string = "http://localhost:8080/";

  constructor(private http: HttpClient) {
  }

  login(form: ILoginForm): Observable<any> {
    return this.http.post(this.baseUrl + 'authenticate.ss', form);
  }

  register(form: IRegisterForm): Observable<any> {
    return this.http.post(this.baseUrl + 'registerUser.ss', form);
  }
}
