import {Component, OnInit} from '@angular/core';
import {Availability} from '../models/availability';
import {Router} from '@angular/router';
import {AvailabilityService} from '../services/availability.service';
import {AuthenticateService} from '../services/authenticate.service';

@Component({
  selector: 'app-availability',
  templateUrl: './availability-list.component.html',
  styleUrls: ['./availability-list.component.css'],
  providers: [AvailabilityService]
})

export class AvailabilityListComponent implements OnInit {
  availabilities: Availability[] = [];

  constructor(private httpService: AvailabilityService, public router: Router, private auth: AuthenticateService) {
  }

  ngOnInit() {
    if (this.authenticated()) {
      this.httpService.getAll().subscribe((data: Availability[]) => this.availabilities = data);
    }
  }

  authenticated() {
    return this.auth.isUserLoggedIn();
  }
}
