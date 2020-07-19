import {Component, OnInit} from '@angular/core';
import {AuthenticateService} from './services/authenticate.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'PharmacyWeb';

  constructor(private auth: AuthenticateService, private router: Router) {
  }

  logout() {
    this.auth.logout();
    this.router.navigateByUrl('/login');
  }

  ngOnInit(): void {
  }
}
