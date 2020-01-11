import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { Reimb } from 'src/app/models/reimb';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  reimbData: Reimb = null;
  constructor(private uServe: UserService, private router: Router) { }

  ngOnInit() {
  }



  popTable() {
    this.uServe.popTable(1).subscribe(
      (reimbModels: Reimb) => {
        console.log(reimbModels);
        this.reimbData = reimbModels;
      }
    )
  } username(username: any, password: any) {
    throw new Error("Method not implemented.");
  }
  password(username: any, password: any) {
    throw new Error("Method not implemented.");
  }
}
