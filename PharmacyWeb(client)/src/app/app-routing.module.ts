import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const appRoutes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', loadChildren: () => import('./authentication/login.module').then(m => m.LoginModule)},
  {path: 'phar', loadChildren: () => import('./pharmacyt/pharmacyt.module').then(m => m.PharmacytModule)},
  {path: 'med', loadChildren: () => import('./medicine/medicine.module').then(m => m.MedicineModule)},
  {path: 'avail', loadChildren: () => import('./availability/availability.module').then(m => m.AvailabilityModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
