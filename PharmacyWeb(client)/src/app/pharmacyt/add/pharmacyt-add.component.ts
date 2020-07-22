import {Component, OnInit} from '@angular/core';
import {Pharmacyt} from '../../models/pharmacyt';
import {Router} from '@angular/router';
import {PharmacytService} from '../../services/pharmacyt.service';
import {AuthenticateService} from '../../services/authenticate.service';

@Component({
  selector: 'app-root',
  templateUrl: './pharmacyt-add.component.html',
  styleUrls: ['./pharmacyt-add.component.css'],
  providers: [PharmacytService]
})

export class PharmacytAddComponent implements OnInit {

  pharmacyts: Pharmacyt = new Pharmacyt();
  error: boolean = false;
  timeStart = {hour: 0, minute: 0};
  timeEnd = {hour: 0, minute: 0};

  constructor(private auth: AuthenticateService, public router: Router, private http: PharmacytService) {
  }

  ngOnInit() {
    if (!this.auth.isUserLoggedIn()) {
      this.router.navigate(['/login']);
    }
  }

  add() {
    this.pharmacyts.workStart = (this.timeStart.hour < 10 ? '0' : '') + this.timeStart.hour + ':' + (this.timeStart.minute < 10 ? '0' : '') + this.timeStart.minute;
    this.pharmacyts.workEnd = (this.timeEnd.hour < 10 ? '0' : '') + this.timeEnd.hour + ':' + (this.timeEnd.minute < 10 ? '0' : '') + this.timeEnd.minute;
    this.http.add(this.pharmacyts).subscribe(() => {
      this.router.navigate(['phar']);
      this.error = false;
    }, () => {
      this.error = true;
    });
  }
}
