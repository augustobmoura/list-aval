import { Injectable } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { Observable } from 'rxjs';
import { tap, filter } from 'rxjs/operators'


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  lastUrl: string

  constructor(private route: Router) {
    this.route.events
    .pipe(
      filter(e => e instanceof NavigationEnd)
    ).subscribe((e : NavigationEnd) => this.lastUrl = e.url)
  }

  get isLoggein(){
    const token = localStorage.getItem('userValid')
    if(!token) {
      return false;
    }
    return true
  }

  handleLogin(path: string = this.lastUrl){
    this.route.navigate(['/login', btoa(path)])
  }

  logOut(){
      localStorage.removeItem("userValid")
      this.route.navigate(['/login'])
  }
}
