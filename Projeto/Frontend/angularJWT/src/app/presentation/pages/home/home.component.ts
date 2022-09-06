import { Component, OnInit } from '@angular/core';
import { UserService } from '@app/domain/_services/user.service';
import { first } from 'rxjs';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  loading = false;
  users: any;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.loading = true;
    this.userService.getAll().pipe(first()).subscribe((users: any) => {
        this.loading = false;
        this.users = users;
    });
  }

}
