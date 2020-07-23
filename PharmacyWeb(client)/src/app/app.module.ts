import {BrowserModule} from '@angular/platform-browser';
import {Injectable, NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {AuthenticateService} from './services/authenticate.service';
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
    AppComponent
  ],
  imports: [AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AuthenticateService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: XhrInterceptor,
      multi: true,
    }],
  bootstrap: [AppComponent]
})
export class AppModule {
}
