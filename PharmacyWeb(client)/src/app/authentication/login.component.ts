import {Component} from '@angular/core';
import {AuthenticateService} from '../services/authenticate.service';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {
  credentials = {username: '', password: ''};

  constructor(private auth: AuthenticateService,
              private http: HttpClient,
              private router: Router) {
  }

  login() {
    this.auth.authenticate(this.credentials).subscribe((result) => {
      if (result) {
        sessionStorage.setItem('username', this.credentials.username);
        sessionStorage.setItem('token', 'Basic ' + btoa(this.credentials.username + ':' + this.credentials.password));
        this.router.navigateByUrl('/');
      }
    });
  }

  authenticated() {
    return this.auth.isUserLoggedIn();
  }

  logout() {
    this.auth.logout();
  }
}
