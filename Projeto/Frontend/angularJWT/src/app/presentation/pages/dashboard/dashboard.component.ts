import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '@app/domain/_models';
import { AuthenticationService } from '@app/domain/_services';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  currentUser!: User;
  accessToken!: String;

  public collapsed = false;
  public isCollapsed = false;

  active = 'top';
  http: any;
  constructor(private router: Router,
    private authenticationService: AuthenticationService) {
    this.currentUser = authenticationService.currentUser;
    this.accessToken = authenticationService.accessToken;
  }
  
  
  ngOnInit(): void {

  }

  getCurrentUser(): void {
  
  }

  logout(): void {
    this.authenticationService.logout();
    this.router.navigate(['']);
  }

}

