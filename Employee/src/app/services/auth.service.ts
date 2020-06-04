import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { User } from 'src/models/user';
import { Observable } from 'rxjs';

const url="http://localhost:8765/user-service/login";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(public userService:UserService, public http:HttpClient) { }
  authenticate(email: string, password: string): Observable<User> {
    // create a security token
    let authenticationToken = "Basic " + window.btoa(email + ":" + password);
    console.log(authenticationToken);
    let headers = new HttpHeaders({
      Authorization: authenticationToken
    });
    console.log("calling server")
    // send the request
    return this.http.get<User>(url, { headers }).pipe(
      // success function
      map((successData:User) => {
        console.log("success ")
        sessionStorage.setItem("email", email);
        // save the token
        sessionStorage.setItem("token", authenticationToken);
  
        return successData;
      }),
      // failure function
      map(failureData => {
        // console message 
        console.log("failure")
        return failureData;
      })
    );
  }
  getAuthenticationToken() {
    if (this.isUserLoggedIn())
      return sessionStorage.getItem("token");
    return null;
  }
  isUserLoggedIn(): boolean {
    let user = sessionStorage.getItem('email');
    if (user == null)
      return false;
    return true;
  }

  logout() {
    sessionStorage.removeItem('email');
    sessionStorage.removeItem("token")
  }


}
