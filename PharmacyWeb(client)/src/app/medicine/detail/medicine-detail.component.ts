import {Component, OnInit} from '@angular/core';
import {Medicine} from '../../models/medicine';
import {ActivatedRoute, Router} from '@angular/router';
import {MedicineService} from '../../services/medicine.service';
import {AuthenticateService} from '../../services/authenticate.service';
import {NgbDateParserFormatter, NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-root',
  templateUrl: './medicine-detail.component.html',
  styleUrls: ['./medicine-detail.component.css'],
  providers: [MedicineService]
})

export class MedicineDetailComponent implements OnInit {
  medicines: Medicine;
  id: number;
  updError: boolean = false;
  delError: boolean = false;
  date: NgbDateStruct = {
    year: 2020,
    month: 1,
    day: 1
  };

  constructor(private auth: AuthenticateService, private activateRoute: ActivatedRoute, private httpService: MedicineService,
              public router: Router, private parserFormatter: NgbDateParserFormatter) {
    this.id = activateRoute.snapshot.params['id'];
  }

  ngOnInit() {
    if (!this.auth.isUserLoggedIn()) {
      this.router.navigate(['/login']);
    }
    this.httpService.getID(this.id).subscribe((data: Medicine) => {
      this.medicines = data;
      if (this.medicines.expirationDate != null) {
        this.date = this.httpService.getDate(this.medicines.expirationDate);
      }
    });
  }

  save() {
    this.medicines.expirationDate = new Date(this.parserFormatter.format(this.date));
    this.httpService.save(this.medicines).subscribe(() => {
      this.router.navigate(['/med']);
      this.updError = false;
    }, () => {
      this.updError = true;
    });
  }

  delete() {
    this.httpService.delete(this.id).subscribe(() => {
      this.router.navigate(['/med']);
      this.delError = false;
    }, () => {
      this.delError = true;
    });
  }
}
