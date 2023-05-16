import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VoituresComponent } from './voitures/voitures.component';
import { AddVoitureComponent } from './add-voiture/add-voiture.component';

const routes: Routes = [
  {path: "voitures", component : VoituresComponent},
  {path: "add-voiture", component : AddVoitureComponent},
  { path: "", redirectTo: "voitures", pathMatch: "full" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
