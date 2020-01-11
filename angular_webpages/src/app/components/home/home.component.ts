import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {



  constructor(private uServe: UserService, private router: Router) { }

  ngOnInit() {
  }



  popTable() {
    this.uServe.login(this.username, this.password).subscribe(
      (userModel: User) => {
        console.log(userModel);
        console.log(userModel.userRole);
        //sessionStorage.setItem('currentUser', JSON.stringify(response));
        // console.log(response);
        this.router.navigate(['/home']);
      }
    )
  }  username(username: any, password: any) {
    throw new Error("Method not implemented.");
  }
  password(username: any, password: any) {
    throw new Error("Method not implemented.");
  }

