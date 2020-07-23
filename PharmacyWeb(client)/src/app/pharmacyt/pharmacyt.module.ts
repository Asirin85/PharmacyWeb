import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {PharmacytListComponent} from './pharmacyt-list.component';
import {PharmacytRoutingModule} from './pharmacyt-routing.module';
import {CommonModule} from '@angular/common';
import {PharmacytAddComponent} from './add/pharmacyt-add.component';
import {PharmacytDetailComponent} from './detail/pharmacyt-detail.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  imports: [CommonModule, FormsModule, PharmacytRoutingModule, NgbModule],
  declarations: [PharmacytListComponent, PharmacytAddComponent, PharmacytDetailComponent]
})
export class PharmacytModule {
}

