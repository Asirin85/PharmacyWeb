import {BrowserModule} from '@angular/platform-browser';
import {Injectable, NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {PharmacytListComponent} from './pharmacyt/pharmacyt-list.component';
import {HTTP_INTERCEPTORS, HttpClientModule, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Routes, RouterModule} from '@angular/router';
import {MedicineListComponent} from './medicine/medicine-list.component';
import {AvailabilityListComponent} from './availability/availability-list.component';
import {PharmacytDetailComponent} from './pharmacyt/detail/pharmacyt-detail.component';
import {AvailabilityDetailComponent} from './availability/detail/availability-detail.component';
import {MedicineDetailComponent} from './medicine/detail/medicine-detail.component';
import {FormsModule} from '@angular/forms';
import {PharmacytAddComponent} from './pharmacyt/add/pharmacyt-add.component';
import {AvailabilityAddComponent} from './availability/add/availability-add.component';
import {MedicineAddComponent} from './medicine/add/medicine-add.component';
import {LoginComponent} from './authentication/login.component';
import {AuthenticateService} from './services/authenticate.service';

const appRoutes: Routes = [
  {path: '', redirectTo: '/phar', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'phar', component: PharmacytListComponent},
  {path: 'med', component: MedicineListComponent},
  {path: 'avail', component: AvailabilityListComponent},
  {path: 'phar/add', component: PharmacytAddComponent},
  {path: 'avail/add', component: AvailabilityAddComponent},
  {path: 'med/add', component: MedicineAddComponent},
  {path: 'phar/:id', component: PharmacytDetailComponent},
  {path: 'med/:id', component: MedicineDetailComponent},
  {path: 'avail/:id', component: AvailabilityDetailComponent}
];

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
    PharmacytListComponent,
    MedicineListComponent,
    AvailabilityListComponent,
    PharmacytDetailComponent,
    AvailabilityDetailComponent,
    MedicineDetailComponent,
    PharmacytAddComponent,
    AvailabilityAddComponent,
    MedicineAddComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [AuthenticateService, {provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
