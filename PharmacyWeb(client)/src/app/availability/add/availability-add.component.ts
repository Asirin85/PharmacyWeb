import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Availability} from '../../models/availability';
import {AvailabilityService} from '../../services/availability.service';
import {AuthenticateService} from '../../services/authenticate.service';

@Component({
  selector: 'app-root',
  templateUrl: './availability-add.component.html',
  styleUrls: ['./availability-add.component.css'],
  providers: [AvailabilityService]
})

export class AvailabilityAddComponent {

  availabilities: Availability = new Availability();
  error: boolean = false;

  constructor(private auth: AuthenticateService, public router: Router, private httpService: AvailabilityService) {
  }

  ngOnInit() {
    if (!this.auth.isUserLoggedIn()) {
      this.router.navigate(['/login']);
    }
  }

  add() {
    this.httpService.add(this.availabilities).subscribe(() => {
      this.router.navigate(['avail']);
      this.error = false;
    }, () => {
      this.error = true;
    });
  }
}
