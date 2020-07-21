import {Component, OnInit} from '@angular/core';
import {Availability} from '../../models/availability';
import {ActivatedRoute, Router} from '@angular/router';
import {AvailabilityService} from '../../services/availability.service';
import {AuthenticateService} from '../../services/authenticate.service';

@Component({
  selector: 'app-root',
  templateUrl: './availability-detail.component.html',
  styleUrls: ['./availability-detail.component.css'],
  providers: [AvailabilityService]
})

export class AvailabilityDetailComponent implements OnInit {
  availabilities: Availability;
  id: number;
  error: boolean = false;

  constructor(private auth: AuthenticateService, private activateRoute: ActivatedRoute, private httpService: AvailabilityService, public router: Router) {
    this.id = activateRoute.snapshot.params['id'];
  }

  ngOnInit() {
    if (!this.auth.isUserLoggedIn()) {
      this.router.navigate(['/login']);
    }
    this.httpService.getID(this.id).subscribe((data: Availability) => this.availabilities = data);
  }

  save() {
    this.httpService.save(this.availabilities).subscribe(() => {
      this.router.navigate(['/avail']);
      this.error = false;
    }, () => {
      this.error = true;
    });
  }

  delete() {
    this.httpService.delete(this.id).subscribe(() => {
      this.router.navigate(['/avail']);
      this.error = false;
    }, () => {
      this.error = true;
    });
  }
}
