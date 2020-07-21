import {Component, OnInit} from '@angular/core';
import {Medicine} from '../../models/medicine';
import {ActivatedRoute, Router} from '@angular/router';
import {MedicineService} from '../../services/medicine.service';
import {AuthenticateService} from '../../services/authenticate.service';

@Component({
  selector: 'app-root',
  templateUrl: './medicine-detail.component.html',
  styleUrls: ['./medicine-detail.component.css'],
  providers: [MedicineService]
})

export class MedicineDetailComponent implements OnInit {
  medicines: Medicine;
  id: number;
  error: boolean = false;

  constructor(private auth: AuthenticateService, private activateRoute: ActivatedRoute, private httpService: MedicineService, public router: Router) {
    this.id = activateRoute.snapshot.params['id'];
  }

  ngOnInit() {
    if (!this.auth.isUserLoggedIn()) {
      this.router.navigate(['/login']);
    }
    this.httpService.getID(this.id).subscribe((data: Medicine) => this.medicines = data);
  }

  save() {
    this.httpService.save(this.medicines).subscribe(() => {
      this.router.navigate(['/med']);
      this.error = false;
    }, () => {
      this.error = true;
    });
  }

  delete() {
    this.httpService.delete(this.id).subscribe(() => {
      this.router.navigate(['/med']);
      this.error = false;
    }, () => {
      this.error = true;
    });
  }
}
