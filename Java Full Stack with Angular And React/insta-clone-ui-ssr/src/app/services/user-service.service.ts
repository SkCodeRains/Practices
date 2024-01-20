import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private _token!: string;
  private _logged_in: boolean = false;
  public get logged_in(): boolean {
    return this._logged_in;
  }
  public set logged_in(value: boolean) {
    this._logged_in = value;
  }
  public get token(): string {
    return this._token;
  }
  public set token(value: string) {
    this._token = value;
  }
  constructor() { }

}
