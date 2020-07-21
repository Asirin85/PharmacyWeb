import {Component, OnInit} from '@angular/core';
import {Pharmacyt} from '../../models/pharmacyt';
import {Router} from '@angular/router';
import {PharmacytService} from '../../services/pharmacyt.service';
import {AuthenticateService} from '../../services/authenticate.service';

@Component({
  selector: 'app-root',
  templateUrl: './pharmacyt-add.component.html',
  styleUrls: ['./pharmacyt-add.component.css'],
  providers: [PharmacytService]
})

export class PharmacytAddComponent implements OnInit {

  pharmacyts: Pharmacyt = new Pharmacyt();
  error: boolean = false;

  constructor(private auth: AuthenticateService, public router: Router, private http: PharmacytService) {
  }

  ngOnInit() {
    if (!this.auth.isUserLoggedIn()) {
      this.router.navigate(['/login']);
    }
  }

  add() {
    this.http.add(this.pharmacyts).subscribe(() => {
      this.router.navigate(['phar']);
      this.error = false;
    }, () => {
      this.error = true;
    });
  }
}
