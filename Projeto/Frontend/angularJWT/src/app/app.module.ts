import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './presentation/pages/login/login.component';
import { HomeComponent } from './presentation/pages/home/home.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ErrorInterceptor, JwtInterceptor } from './core/interceptors';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RegisterComponent } from './presentation/pages/register/register.component';
import { DashboardCarrosListComponent } from './presentation/pages/dashboard/dashboard-carros-list/dashboard-carros-list.component';
import { DashboardComponent } from './presentation/pages/dashboard';
import { DashboardHomeComponent } from './presentation/pages/dashboard/dashboard-home/dashboard-home.component';
import { DashboardCriarCarrosComponent } from './presentation/pages/dashboard/dashboard-criar-carros/dashboard-criar-carros.component';
import { DashboardDescricaoCarroComponent } from './presentation/pages/dashboard-descricao-carro/dashboard-descricao-carro.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    DashboardHomeComponent,
    DashboardComponent,
    DashboardCarrosListComponent,
    DashboardCriarCarrosComponent,
    DashboardDescricaoCarroComponent,
    
],  
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule
],

providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },

    // provider used to create fake backend
],
bootstrap: [AppComponent]
})
export class AppModule { }
