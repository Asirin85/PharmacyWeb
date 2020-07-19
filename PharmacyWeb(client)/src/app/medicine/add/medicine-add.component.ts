import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Medicine} from '../../models/medicine';
import {MedicineService} from '../../services/medicine.service';

@Component({
  selector: 'app-root',
  templateUrl: './medicine-add.component.html',
  styleUrls: ['./medicine-add.component.css'],
  providers: [MedicineService]
})

export class MedicineAddComponent {

  medicines: Medicine = new Medicine();

  constructor(public router: Router, private httpService: MedicineService) {
  }

  add() {
    this.httpService.add(this.medicines).subscribe(() => this.router.navigate(['med']));
  }

}
