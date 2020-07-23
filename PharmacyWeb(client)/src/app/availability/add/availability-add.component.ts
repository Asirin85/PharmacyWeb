import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Availability} from '../../models/availability';
import {AvailabilityService} from '../../services/availability.service';
import {AuthenticateService} from '../../services/authenticate.service';
import {NgbDateParserFormatter, NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-root',
  templateUrl: './availability-add.component.html',
  styleUrls: ['./availability-add.component.css'],
  providers: [AvailabilityService]
})

export class AvailabilityAddComponent {

  availabilities: Availability = new Availability();
  error: boolean = false;
  date: NgbDateStruct = {
    year: 2020,
    month: 1,
    day: 1
  };

  constructor(private auth: AuthenticateService, public router: Router, private httpService: AvailabilityService, private parserFormatter: NgbDateParserFormatter) {
  }

  ngOnInit() {
    if (!this.auth.isUserLoggedIn()) {
      this.router.navigate(['/login']);
    }
  }

  add() {
    this.availabilities.receiptDate = new Date(this.parserFormatter.format(this.date));
    this.httpService.add(this.availabilities).subscribe(() => {
      this.router.navigate(['avail']);
      this.error = false;
    }, () => {
      this.error = true;
    });
  }
}
