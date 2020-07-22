import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {PharmacytListComponent} from './pharmacyt-list.component';

const routes: Routes=[
  {
    path:'', component: PharmacytListComponent
  }
]
@NgModule({
  imports:[RouterModule.forChild(routes)],
  exports:[RouterModule]
})
export class PharmacytRoutingModule{}
