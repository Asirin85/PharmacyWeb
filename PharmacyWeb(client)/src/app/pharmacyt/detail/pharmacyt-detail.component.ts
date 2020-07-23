import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Pharmacyt} from '../../models/pharmacyt';
import {PharmacytService} from '../../services/pharmacyt.service';
import {AuthenticateService} from '../../services/authenticate.service';

@Component({
  selector: 'pharmacyt-detail',
  templateUrl: './pharmacyt-detail.component.html',
  styleUrls: ['./pharmacyt-detail.component.css'],
  providers: [PharmacytService]
})
export class PharmacytDetailComponent implements OnInit {
  pharmacyts: Pharmacyt;
  id: number;
  updError: boolean = false;
  delError: boolean = false;
  timeStart = {hour: 0, minute: 0};
  timeEnd = {hour: 0, minute: 0};

  constructor(private auth: AuthenticateService, private activateRoute: ActivatedRoute, private httpService: PharmacytService, public router: Router) {
    this.id = activateRoute.snapshot.params['id'];
  }

  ngOnInit() {
    if (!this.auth.isUserLoggedIn()) {
      this.router.navigate(['/login']);
    }
    this.httpService.getID(this.id).subscribe((data: Pharmacyt) => {
      this.pharmacyts = data;
      this.timeStart = this.httpService.getTime(this.pharmacyts.workStart);
      this.timeEnd = this.httpService.getTime(this.pharmacyts.workEnd);
    });
  }

  save() {
    this.pharmacyts.workStart = (this.timeStart.hour < 10 ? '0' : '') + this.timeStart.hour + ':' + (this.timeStart.minute < 10 ? '0' : '') + this.timeStart.minute;
    this.pharmacyts.workEnd = (this.timeEnd.hour < 10 ? '0' : '') + this.timeEnd.hour + ':' + (this.timeEnd.minute < 10 ? '0' : '') + this.timeEnd.minute;
    this.httpService.save(this.pharmacyts).subscribe(() => {
      this.router.navigate(['/phar']);
      this.updError = false;
    }, () => {
      this.updError = true;
    });
  }

  delete() {
    this.httpService.delete(this.id).subscribe(() => {
      this.router.navigate(['/phar']);
      this.delError = false;
    }, () => {
      this.delError = true;
    });
  }
}
