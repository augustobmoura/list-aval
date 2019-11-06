import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from './login.service';
import { AlertService } from 'ngx-alerts';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {

  loginForm: FormGroup
  navigateTo: string
  constructor(private fb: FormBuilder,
              private activeRoute: ActivatedRoute,
              private route: Router,
              private loginService: LoginService,
              private alertService: AlertService) {
    this.loginForm = fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  ngOnInit() {
    if(this.loginService.isLoggein){
      if(localStorage.getItem('userValid') === 'alunoVALID' ){
        this.route.navigate(['/aluno/minhas-listas'])
      }
      if(localStorage.getItem('userValid') === 'professorVALID' ){
        this.route.navigate(['/professor'])
      }
    }
  }

  onSubmit(){
    if(this.loginForm.value.email === 'aluno@email.com'){
      localStorage.setItem('userValid', 'alunoVALID')
      this.route.navigate(['/aluno/minhas-listas'])
    }
    else if(this.loginForm.value.email === 'professor@email.com'){
      localStorage.setItem('userValid', 'professorVALID')
      this.route.navigate(['/professor'])
    }
    else if(this.loginForm.value.email === 'admin@email.com'){
      localStorage.setItem('userValid', 'evaluatorVALID')
      this.route.navigate(['/avaliador'])
    }
    else{
      this.alertService.danger('Usuário ou senha inválidos!');
    }
  }

}
