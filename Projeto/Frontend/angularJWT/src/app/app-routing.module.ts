import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './presentation/pages/login';
import { RegisterComponent } from './presentation/pages/register/register.component';
import { AuthGuard } from './core/interceptors';
import { DashboardComponent } from './presentation/pages/dashboard';
import { DashboardCarrosListComponent } from './presentation/pages/dashboard/dashboard-carros-list/dashboard-carros-list.component';
import { DashboardCriarCarrosComponent } from './presentation/pages/dashboard/dashboard-criar-carros/dashboard-criar-carros.component';
import { DashboardHomeComponent } from './presentation/pages/dashboard/dashboard-home/dashboard-home.component';
import { DashboardDescricaoCarroComponent } from './presentation/pages/dashboard-descricao-carro/dashboard-descricao-carro.component';

const routes: Routes = [
  // otherwise redirect to home
  { path: '**', redirectTo: 'dashboard/' },
  { path: '', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  {path:'dashboard', component: DashboardComponent, canActivate: [AuthGuard], children : [
    {path:'carrosList', component: DashboardCarrosListComponent},
    {path:'carrosCreate', component: DashboardCriarCarrosComponent},
    {path:'dashboard-home', component: DashboardHomeComponent},
    {path:'descricaoCarro', component: DashboardDescricaoCarroComponent}
]}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
