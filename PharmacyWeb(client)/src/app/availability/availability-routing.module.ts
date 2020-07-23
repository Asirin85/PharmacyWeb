import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AvailabilityListComponent} from './availability-list.component';
import {AvailabilityDetailComponent} from './detail/availability-detail.component';
import {AvailabilityAddComponent} from './add/availability-add.component';

const routes: Routes = [
  {
    path: '', component: AvailabilityListComponent
  },

  {
    path: 'add', component: AvailabilityAddComponent
  },
  {
    path: ':id', component: AvailabilityDetailComponent
  }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  }
)
export class AvailabilityRoutingModule {
}
