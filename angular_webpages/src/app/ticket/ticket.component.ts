import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css'],
  template: `
  <h1 *ngIf="displayHeading">Display Works</h1>
//   <form *ngIf="displayName">
//   <!-- Grid row -->
//   <div class="row">
//     <!-- Grid column -->
//     <div class="col">
//       <!-- Default input -->
//       <input type="text" class="form-control" placeholder="First name">
//     </div>
//     <!-- Grid column -->

//     <!-- Grid column -->
//     <div class="col">
//       <!-- Default input -->
//       <input type="text" class="form-control" placeholder="Last name">
//     </div>
//     <!-- Grid column -->
//   </div>
//   <!-- Grid row -->
// </form>
 `

})
export class TicketComponent implements OnInit {

  displayHeading = true;
  constructor() { }

  ngOnInit() {
  }

}
