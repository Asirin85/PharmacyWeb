import {Injectable, NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {PharmacytListComponent} from './pharmacyt-list.component';
import {PharmacytRoutingModule} from './pharmacyt-routing.module';
import {HTTP_INTERCEPTORS, HttpClientModule, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import {AuthenticateService} from '../services/authenticate.service';
@Injectable()
export class XhrInterceptor implements HttpInterceptor {
  constructor(public auth: AuthenticateService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const token = sessionStorage.getItem('token');
    if (!!token) {
      const headers = new HttpHeaders({Authorization: token});
      req = req.clone({
        headers: headers
      });
    }
    return next.handle(req);
  }
}
@NgModule({
  imports:[HttpClientModule,CommonModule,FormsModule, PharmacytRoutingModule],
  declarations:[PharmacytListComponent],
  providers:[{provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true}]
})
export class PharmacytModule {
}

