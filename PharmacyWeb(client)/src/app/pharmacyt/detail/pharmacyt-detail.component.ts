import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Pharmacyt} from '../../models/pharmacyt';
import {PharmacytService} from '../../services/pharmacyt.service';

@Component({
  selector: 'pharmacyt-detail',
  templateUrl: './pharmacyt-detail.component.html',
  styleUrls: ['./pharmacyt-detail.component.css'],
  providers: [PharmacytService]
})
export class PharmacytDetailComponent implements OnInit {
  pharmacyts: Pharmacyt;
  id: number;

  constructor(private activateRoute: ActivatedRoute, private httpService: PharmacytService, public router: Router) {
    this.id = activateRoute.snapshot.params['id'];
  }

  ngOnInit() {
    this.httpService.getID(this.id).subscribe((data: Pharmacyt) => this.pharmacyts = data);
  }

  save() {
    this.httpService.save(this.pharmacyts).subscribe(() => this.router.navigate(['/phar']));
  }

  delete() {
    this.httpService.delete(this.id).subscribe(() => this.router.navigate(['/phar']));
  }

}
