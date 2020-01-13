import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, ArgumentOutOfRangeError } from 'rxjs';
import { User } from '../models/user';
import { Reimb } from '../models/reimb';

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

    return this.http.post<User>('http://localhost:8080/ProjectOne/login', body);
  }

  logout() {
    return this.http.post<void>("http://localhost:8080/ProjectOne/logout", {});
  }

  popTable(id: number): Observable<Reimb> {
    let headers = new HttpHeaders({
      "id": id.toString()
    });

    return this.http.get<Reimb>('http://localhost:8080/ProjectOne/getTable', { headers: headers });
  }


  createTicket(userId: number, amount: number, type: number, description: string) {
    let headers = new HttpHeaders({
      "id": userId.toString()
    });
    let body = {
      "amount": amount.toString(),
      "typeId": type.toString(), 
      "description": description.toString()
    };
    return this.http.post<Reimb>('http://localhost:8080/ProjectOne/createTicket', body, {headers: headers});
  }
}
