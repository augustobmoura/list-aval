import { Injectable } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { filter } from 'rxjs/operators';

const TOKEN_KEY = 'token';

@Injectable({
  providedIn: 'root',
})
export class LoginService {

  lastUrl: string;

  token?: string = localStorage.getItem(TOKEN_KEY) || undefined;
  role?: 'DISCENTE' | 'DOCENTE';

  constructor(private route: Router) {
    this.route.events.pipe(
      filter(e => e instanceof NavigationEnd),
    ).subscribe((e: NavigationEnd) => this.lastUrl = e.url);
  }

  async login(user: string, password: string) {
  }

  logOut() {
    localStorage.removeItem(TOKEN_KEY);
    this.token = undefined;
    this.role = undefined;
    this.route.navigate(['/login']);
  }
}
