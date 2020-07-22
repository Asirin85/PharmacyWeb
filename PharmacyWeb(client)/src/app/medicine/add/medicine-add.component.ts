import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Medicine} from '../../models/medicine';
import {MedicineService} from '../../services/medicine.service';
import {AuthenticateService} from '../../services/authenticate.service';
import {NgbDateParserFormatter, NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-root',
  templateUrl: './medicine-add.component.html',
  styleUrls: ['./medicine-add.component.css'],
  providers: [MedicineService]
})

export class MedicineAddComponent implements OnInit {

  medicines: Medicine = new Medicine();
  error: boolean = false;
  date: NgbDateStruct = {
    year: 2020,
    month: 1,
    day: 1
  };

  constructor(private auth: AuthenticateService, public router: Router, private httpService: MedicineService, private parserFormatter: NgbDateParserFormatter) {
  }

  ngOnInit() {
    if (!this.auth.isUserLoggedIn()) {
      this.router.navigate(['/login']);
    }
  }

  add() {
    this.medicines.expirationDate = new Date(this.parserFormatter.format(this.date));
    this.httpService.add(this.medicines).subscribe(() => {
      this.router.navigate(['med']);
      this.error = false;
    }, () => {
      this.error = true;
    });
  }
}
