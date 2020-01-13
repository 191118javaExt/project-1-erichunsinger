import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = 'MrBigglesworth';
  password: string = 'HisPassword';

  constructor(private uServe: UserService, private router: Router) { }

  ngOnInit() {

  }

  sendLogin() {
    this.uServe.login(this.username, this.password).subscribe(
      (userModel: User) => {
        localStorage.setItem('currentUser', JSON.stringify(userModel));
        // console.log(response);
        this.router.navigate(['/home']);
      }
    )
  }
}
