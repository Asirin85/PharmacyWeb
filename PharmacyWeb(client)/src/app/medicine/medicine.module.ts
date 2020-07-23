import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {MedicineRoutingModule} from './medicine-routing.module';
import {MedicineListComponent} from './medicine-list.component';
import {MedicineAddComponent} from './add/medicine-add.component';
import {MedicineDetailComponent} from './detail/medicine-detail.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  imports: [CommonModule, FormsModule, MedicineRoutingModule, NgbModule],
  declarations: [MedicineListComponent, MedicineAddComponent, MedicineDetailComponent]
})
export class MedicineModule {
}
