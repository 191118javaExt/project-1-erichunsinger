import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<User> {
    let body: any =
    {
      username: username,
      password: password
    };

    return this.http.post<User>('http://localhost:8080/ProjectOne/login',body);
  }

  logout() {
    return this.http.post<void>("http://localhost:8080/ProjectOne/logout", {});
  }

  popTable(id: number): Observable<User> {
    let headers = new HttpHeaders({
      "id": id.toString()
  });

    return this.http.get<User>('http://localhost:8080/ProjectOne/getTable', {headers: headers});
  }
}
