import {Component, OnInit} from '@angular/core';
import {Pharmacyt} from '../../models/pharmacyt';
import {Router} from '@angular/router';
import {PharmacytService} from '../../services/pharmacyt.service';

@Component({
  selector: 'app-root',
  templateUrl: './pharmacyt-add.component.html',
  styleUrls: ['./pharmacyt-add.component.css'],
  providers: [PharmacytService]
})

export class PharmacytAddComponent {

  pharmacyts: Pharmacyt = new Pharmacyt();

  constructor(public router: Router, private http: PharmacytService) {
  }

  add() {
    this.http.add(this.pharmacyts).subscribe(() => this.router.navigate(['phar']));
  }

}
