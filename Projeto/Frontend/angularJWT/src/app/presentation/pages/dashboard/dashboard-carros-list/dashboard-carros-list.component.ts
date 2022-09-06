import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Carro } from '@app/domain/_models/carro';
import { Curtida } from '@app/domain/_models/curtida';
import { CarroService } from '@app/domain/_services/carro.service';
import { CurtidaService } from '@app/domain/_services/curtida.service';

@Component({
  selector: 'app-dashboard-carros-list',
  templateUrl: './dashboard-carros-list.component.html',
  styleUrls: ['./dashboard-carros-list.component.css']
})
export class DashboardCarrosListComponent implements OnInit {

  carros: Carro[];
  curtidas: Curtida[];

  constructor(
    public curtidaService: CurtidaService, 
    public carroService: CarroService, 
    private router: Router,) { }

  ngOnInit(): void {
    this.listCarros();
    
  }

  listCarros() {
    this.carroService.list()
    .subscribe(carros => this.carros = carros);

  }

  curtidaCarro(id:number) {
    
    this.curtidaService.newCurtida(id).subscribe(
      success => this.listCarros(),
      error => alert("Você já curtiu este carro")
    );
    
  }

  descurtirCarro(id:number) {
    
    this.curtidaService.deleteCurtida(id).subscribe(
      success => this.listCarros(),
      error => alert("Você ainda não curtiu este carro")
      
    );
    
  }
  
  click(carro: Carro) {
    localStorage.setItem('carro', JSON.stringify(carro));
    this.router.navigate(['/dashboard/descricaoCarro/']); 
  }

}


