import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ConstLib} from '../const.lib';
import {map} from 'rxjs/operators';

@Injectable()
export class AuthenticateService {

  constructor(private http: HttpClient) {
  }

  isUserLoggedIn() {
    const user = sessionStorage.getItem('username');
    return !!user;
  }

  logout() {
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('token');
  }

  authenticate(credentials) {
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(credentials.username + ':' + credentials.password)});
    return this.http.get<boolean>(`http://localhost:8080/login?username=${credentials.username}&password=${credentials.password}`, {headers});
  }
}
