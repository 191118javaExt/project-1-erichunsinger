import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { Reimb } from 'src/app/models/reimb';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  currentUser: User;
  createTicket: boolean = false;
  showNewRow: boolean = false;
  @ViewChild("myTable", {static: false}) tableElm: ElementRef;
  
  amount: number = 2.34;
  type: number = 1;
  description: string = "abc";
  submitDate: Date;
  reimbData: Reimb = null;
  constructor(private uServe: UserService, private router: Router) { }

  ngOnInit() {
    let userString: string = localStorage.getItem('currentUser');
    if(userString === null) {
      this.router.navigate(['/login']);
    } else {
      this.currentUser = JSON.parse(userString);
    }
  }


  popTable() {
    this.uServe.popTable(2).subscribe(
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
  createNewRow(){
    console.log("about to add a new row");
    this.amount = 0;
    this.type = 1;
    this.description = "";
    this.showNewRow = true;
  }
  saveNewTicket(){

    this.uServe.createTicket(this.currentUser.userId, this.amount, this.type, this.description).subscribe(
      (reimbModels: Reimb) => {
        this.showNewRow = false;
        this.reimbData = reimbModels;        
      }
    )
  }
}
