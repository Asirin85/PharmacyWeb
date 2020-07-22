import {BrowserModule} from '@angular/platform-browser';
import {Injectable, NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {RouterModule, Routes} from '@angular/router';
import {MedicineListComponent} from './medicine/medicine-list.component';
import {AvailabilityListComponent} from './availability/availability-list.component';
import {PharmacytDetailComponent} from './pharmacyt/detail/pharmacyt-detail.component';
import {AvailabilityDetailComponent} from './availability/detail/availability-detail.component';
import {MedicineDetailComponent} from './medicine/detail/medicine-detail.component';
import {FormsModule} from '@angular/forms';
import {PharmacytAddComponent} from './pharmacyt/add/pharmacyt-add.component';
import {AvailabilityAddComponent} from './availability/add/availability-add.component';
import {MedicineAddComponent} from './medicine/add/medicine-add.component';
import {AuthenticateService} from './services/authenticate.service';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AppRoutingModule} from './app-routing.module';


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
  declarations: [
    AppComponent,
    MedicineListComponent,
    AvailabilityListComponent,
    PharmacytDetailComponent,
    AvailabilityDetailComponent,
    MedicineDetailComponent,
    PharmacytAddComponent,
    AvailabilityAddComponent,
    MedicineAddComponent
  ],
  imports: [AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    FormsModule,
    NgbModule
  ],
  providers: [AuthenticateService, {provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
