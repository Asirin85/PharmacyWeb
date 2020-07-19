import {Component, OnInit} from '@angular/core';
import {Medicine} from '../../models/medicine';
import {ActivatedRoute, Router} from '@angular/router';
import {MedicineService} from '../../services/medicine.service';

@Component({
  selector: 'app-root',
  templateUrl: './medicine-detail.component.html',
  styleUrls: ['./medicine-detail.component.css'],
  providers: [MedicineService]
})

export class MedicineDetailComponent implements OnInit {
  medicines: Medicine;
  id: number;

  constructor(private activateRoute: ActivatedRoute, private httpService: MedicineService, public router: Router) {
    this.id = activateRoute.snapshot.params['id'];
  }

  ngOnInit() {
    this.httpService.getID(this.id).subscribe((data: Medicine) => this.medicines = data);
  }

  save() {
    this.httpService.save(this.medicines).subscribe(() => this.router.navigate(['/med']));
  }

  delete() {
    this.httpService.delete(this.id).subscribe(() => this.router.navigate(['/med']));
  }
}
