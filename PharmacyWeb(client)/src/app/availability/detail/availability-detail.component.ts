import {Component, OnInit} from '@angular/core';
import {Availability} from '../../models/availability';
import {ActivatedRoute, Router} from '@angular/router';
import {AvailabilityService} from '../../services/availability.service';

@Component({
  selector: 'app-root',
  templateUrl: './availability-detail.component.html',
  styleUrls: ['./availability-detail.component.css'],
  providers: [AvailabilityService]
})

export class AvailabilityDetailComponent implements OnInit {
  availabilities: Availability;
  id: number;

  constructor(private activateRoute: ActivatedRoute, private httpService: AvailabilityService, public router: Router) {
    this.id = activateRoute.snapshot.params['id'];
  }

  ngOnInit() {
    this.httpService.getID(this.id).subscribe((data: Availability) => this.availabilities = data);
  }

  save() {
    this.httpService.save(this.availabilities).subscribe(() => this.router.navigate(['/avail']));
  }

  delete() {
    this.httpService.delete(this.id).subscribe(() => this.router.navigate(['/avail']));
  }
}
