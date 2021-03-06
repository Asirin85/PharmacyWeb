import {Component, OnInit} from '@angular/core';
import {Medicine} from '../models/medicine';
import {Router} from '@angular/router';
import {MedicineService} from '../services/medicine.service';
import {AuthenticateService} from '../services/authenticate.service';

@Component({
  selector: 'app-root',
  templateUrl: './medicine-list.component.html',
  styleUrls: ['./medicine-list.component.css'],
  providers: [MedicineService]
})

export class MedicineListComponent implements OnInit {
  medicines: Medicine[] = [];

  constructor(private httpService: MedicineService, public router: Router, private auth: AuthenticateService) {
  }

  ngOnInit() {
    if (this.authenticated()) {
      this.httpService.getAll().subscribe((data: Medicine[]) => this.medicines = data);
    } else {
      this.router.navigate(['/login']);
    }
  }

  authenticated() {
    return this.auth.isUserLoggedIn();
  }
}
