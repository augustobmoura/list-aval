import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginService } from '../core/pages/login-page/login.service';


@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(
    private readonly loginService: LoginService,
  ) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this._isInternal(new URL(req.url, location.href)) && this.loginService.token) {
      req = req.clone({
        setHeaders: {
          'Authorization': `Bearer ${this.loginService.token}`,
        },
      });
    }

    return next.handle(req);
  }

  private _isInternal(url: URL) {
    const thisUrl = new URL(location.href);
    return url.host === thisUrl.host;
  }

}
