import { Injectable } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { filter } from 'rxjs/operators';
import { ApiLoginService } from '../../../../../lib/server-client/src';

const TOKEN_KEY = 'token';

@Injectable({
  providedIn: 'root',
})
export class LoginService {

  lastUrl: string;

  token?: string = localStorage.getItem(TOKEN_KEY) || undefined;
  role?: 'DISCENTE' | 'DOCENTE';

  constructor(
    private readonly route: Router,
    private readonly apiLoginService: ApiLoginService,
  ) {
    this.route.events.pipe(
      filter(e => e instanceof NavigationEnd),
    ).subscribe((e: NavigationEnd) => this.lastUrl = e.url);
  }

  async login(user: string, password: string) {
    const res = await this.apiLoginService.login({
      email: user,
      senha: password,
    }).toPromise();

    this.token = res.token;
    this.role = res.role as any;
  }

  logOut() {
    localStorage.removeItem(TOKEN_KEY);
    this.token = undefined;
    this.role = undefined;
    this.route.navigate(['/login']);
  }
}
