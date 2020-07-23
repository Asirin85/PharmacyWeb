import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {PharmacytListComponent} from './pharmacyt-list.component';
import {PharmacytDetailComponent} from './detail/pharmacyt-detail.component';
import {PharmacytAddComponent} from './add/pharmacyt-add.component';

const routes: Routes = [
  {path: '', component: PharmacytListComponent,},
  {path: 'add', component: PharmacytAddComponent},
  {path: ':id', component: PharmacytDetailComponent},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PharmacytRoutingModule {
}
