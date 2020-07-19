import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Availability} from '../../models/availability';
import {AvailabilityService} from '../../services/availability.service';

@Component({
  selector: 'app-root',
  templateUrl: './availability-add.component.html',
  styleUrls: ['./availability-add.component.css'],
  providers: [AvailabilityService]
})

export class AvailabilityAddComponent {

  availabilities: Availability = new Availability();

  constructor(public router: Router, private httpService: AvailabilityService) {
  }

  add() {
    this.httpService.add(this.availabilities).subscribe(() => this.router.navigate(['avail']));
  }
}
