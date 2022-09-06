import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from '@app/domain/_services';
import { UserService } from '@app/domain/_services/user.service';
import { first } from 'rxjs';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  signUpForm: FormGroup;
  router: any;

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService
  ) {

  }

  ngOnInit() {
    this.signUpForm = this.formBuilder.group({
      nome: ['', Validators.required],
      login: ['', Validators.required],
      email: ['', Validators.required],
      senha: ['', Validators.required]
    });
  }

  onSubmit(): void {
    this.userService.createUser(this.signUpForm.value).subscribe(
      success => alert("Usuário cadastrado com sucesso!"),
      error => alert("Falha ao cadastrar usuário.")
    );
    
  }

}
