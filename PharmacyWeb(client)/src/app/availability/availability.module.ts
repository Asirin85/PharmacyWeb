import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AvailabilityRoutingModule} from './availability-routing.module';
import {AvailabilityListComponent} from './availability-list.component';
import {AvailabilityAddComponent} from './add/availability-add.component';
import {AvailabilityDetailComponent} from './detail/availability-detail.component';

@NgModule({
  imports: [CommonModule, FormsModule, NgbModule, AvailabilityRoutingModule],
  declarations: [AvailabilityListComponent, AvailabilityAddComponent, AvailabilityDetailComponent]
})
export class AvailabilityModule {
}
