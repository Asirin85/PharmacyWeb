import {Component, OnInit} from '@angular/core';
import {Pharmacyt} from '../models/pharmacyt';
import {Router} from '@angular/router';
import {PharmacytService} from '../services/pharmacyt.service';
import {AuthenticateService} from '../services/authenticate.service';

@Component({
  selector: 'app-root',
  templateUrl: './pharmacyt-list.component.html',
  styleUrls: ['./pharmacyt-list.component.css'],
  providers: [PharmacytService]
})

export class PharmacytListComponent implements OnInit {
  pharmacyts: Pharmacyt[] = [];

  constructor(private httpService: PharmacytService, public router: Router, private auth: AuthenticateService) {
  }

  ngOnInit() {
    if (this.authenticated()) {
      this.httpService.getAll().subscribe((data: Pharmacyt[]) => this.pharmacyts = data);
    }
  }

  authenticated() {
    return this.auth.isUserLoggedIn();
  }
}
