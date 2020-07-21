import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Medicine} from '../../models/medicine';
import {MedicineService} from '../../services/medicine.service';
import {AuthenticateService} from '../../services/authenticate.service';

@Component({
  selector: 'app-root',
  templateUrl: './medicine-add.component.html',
  styleUrls: ['./medicine-add.component.css'],
  providers: [MedicineService]
})

export class MedicineAddComponent implements OnInit {

  medicines: Medicine = new Medicine();
  error: boolean = false;

  constructor(private auth: AuthenticateService, public router: Router, private httpService: MedicineService) {
  }

  ngOnInit() {
    if (!this.auth.isUserLoggedIn()) {
      this.router.navigate(['/login']);
    }
  }

  add() {
    this.httpService.add(this.medicines).subscribe(() => {
      this.router.navigate(['med']);
      this.error = false;
    }, () => {
      this.error = true;
    });
  }
}
