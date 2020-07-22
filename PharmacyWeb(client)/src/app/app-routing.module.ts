import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MedicineListComponent} from './medicine/medicine-list.component';
import {AvailabilityListComponent} from './availability/availability-list.component';
import {PharmacytAddComponent} from './pharmacyt/add/pharmacyt-add.component';
import {AvailabilityAddComponent} from './availability/add/availability-add.component';
import {MedicineAddComponent} from './medicine/add/medicine-add.component';
import {PharmacytDetailComponent} from './pharmacyt/detail/pharmacyt-detail.component';
import {MedicineDetailComponent} from './medicine/detail/medicine-detail.component';
import {AvailabilityDetailComponent} from './availability/detail/availability-detail.component';

const appRoutes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', loadChildren:()=>import('./authentication/login.module').then(m=>m.LoginModule)},
  {path: 'phar', loadChildren:()=>import('./pharmacyt/pharmacyt.module').then(m=>m.PharmacytModule)},
  {path: 'med', component: MedicineListComponent},
  {path: 'avail', component: AvailabilityListComponent},
  {path: 'phar/add', component: PharmacytAddComponent},
  {path: 'avail/add', component: AvailabilityAddComponent},
  {path: 'med/add', component: MedicineAddComponent},
  {path: 'phar/:id', component: PharmacytDetailComponent},
  {path: 'med/:id', component: MedicineDetailComponent},
  {path: 'avail/:id', component: AvailabilityDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule{ }
