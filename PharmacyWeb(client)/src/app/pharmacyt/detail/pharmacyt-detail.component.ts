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
  error: boolean = false;

  constructor(private auth: AuthenticateService, private activateRoute: ActivatedRoute, private httpService: PharmacytService, public router: Router) {
    this.id = activateRoute.snapshot.params['id'];
  }

  ngOnInit() {
    if (!this.auth.isUserLoggedIn()) {
      this.router.navigate(['/login']);
    }
    this.httpService.getID(this.id).subscribe((data: Pharmacyt) => this.pharmacyts = data);
  }

  save() {
    this.httpService.save(this.pharmacyts).subscribe(() => {
      this.router.navigate(['/phar']);
      this.error = false;
    }, () => {
      this.error = true;
    });
  }

  delete() {
    this.httpService.delete(this.id).subscribe(() => {
      this.router.navigate(['/phar']);
      this.error = false;
    }, () => {
      this.error = true;
    });
  }
}
