import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from './login.service';
import { AlertService } from 'ngx-alerts';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss'],
})
export class LoginPageComponent implements OnInit {

  loginForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private route: Router,
    private loginService: LoginService,
    private alertService: AlertService,
  ) {
    this.loginForm = fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  ngOnInit() {
    this.redirect();
  }

  redirect() {
    if (this.loginService.role === 'DISCENTE') {
      this.route.navigate(['/aluno/minhas-listas']);
    } else {
      this.route.navigate(['/professor']);
    }
  }

  async onSubmit() {
    const { email, password } = this.loginForm.value;

    try {
      await this.loginService.login(email, password);
      this.redirect();
    } catch (e) {
      console.log(e);
      this.alertService.danger(`Erro ao logar`);
    }
  }

}
