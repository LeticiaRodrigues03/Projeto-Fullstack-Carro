import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '@app/domain/_services';
import { CarroService } from '@app/domain/_services/carro.service';


@Component({
  selector: 'app-dashboard-criar-carros',
  templateUrl: './dashboard-criar-carros.component.html',
  styleUrls: ['./dashboard-criar-carros.component.css']
})
export class DashboardCriarCarrosComponent implements OnInit {

  signUpForm: FormGroup;


  constructor(
    private formBuilder: FormBuilder,
    private authenticationService: AuthenticationService,
    private carrosServices: CarroService,
    private router: Router,
  ) {

  }

  ngOnInit() {
    this.signUpForm = this.formBuilder.group({
      nome: ['', Validators.required],
      descricao: ['', Validators.required],
      tipo: ['', Validators.required]
    });
  }

  onSubmit(): void {
    this.carrosServices.create(this.signUpForm.value).subscribe(
      success => alert("Carro cadastrado com sucesso!"),
      error => alert("Falha ao cadastrar o carro.")
    );
    
  }
  
}
