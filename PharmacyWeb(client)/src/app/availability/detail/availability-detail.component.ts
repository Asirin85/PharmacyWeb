import {Component, OnInit} from '@angular/core';
import {Availability} from '../../models/availability';
import {ActivatedRoute, Router} from '@angular/router';
import {AvailabilityService} from '../../services/availability.service';
import {AuthenticateService} from '../../services/authenticate.service';
import {NgbDateParserFormatter, NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-root',
  templateUrl: './availability-detail.component.html',
  styleUrls: ['./availability-detail.component.css'],
  providers: [AvailabilityService]
})

export class AvailabilityDetailComponent implements OnInit {
  availabilities: Availability;
  id: number;
  updError: boolean = false;
  delError: boolean = false;
  date: NgbDateStruct = {
    year: 2020,
    month: 1,
    day: 1
  };

  constructor(private auth: AuthenticateService, private activateRoute: ActivatedRoute, private httpService: AvailabilityService,
              public router: Router, private parserFormatter: NgbDateParserFormatter) {
    this.id = activateRoute.snapshot.params['id'];
  }

  ngOnInit() {
    if (!this.auth.isUserLoggedIn()) {
      this.router.navigate(['/login']);
    }
    this.httpService.getID(this.id).subscribe((data: Availability) => {
      this.availabilities = data;
      if (this.availabilities.receiptDate != null) {
        this.date = this.httpService.getDate(this.availabilities.receiptDate);
      }
    });
  }

  save() {
    this.availabilities.receiptDate = new Date(this.parserFormatter.format(this.date));
    this.httpService.save(this.availabilities).subscribe(() => {
      this.router.navigate(['/avail']);
      this.updError = false;
    }, () => {
      this.updError = true;
    });
  }

  delete() {
    this.httpService.delete(this.id).subscribe(() => {
      this.router.navigate(['/avail']);
      this.delError = false;
    }, () => {
      this.delError = true;
    });
  }
}
