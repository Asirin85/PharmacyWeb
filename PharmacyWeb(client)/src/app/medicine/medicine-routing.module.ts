import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MedicineListComponent} from './medicine-list.component';
import {MedicineAddComponent} from './add/medicine-add.component';
import {MedicineDetailComponent} from './detail/medicine-detail.component';

const routes: Routes = [
  {
    path: '', component: MedicineListComponent
  },
  {
    path: 'add', component: MedicineAddComponent
  },
  {
    path: ':id', component: MedicineDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MedicineRoutingModule {

}
