import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PcsComponent } from './pcs/pcs.component';
import { AddPcComponent } from './add-pc/add-pc.component';
import { UpdatePcComponent } from './update-pc/update-pc.component';
import { RechercheParUserComponent } from './recherche-par-user/recherche-par-user.component';
import { RechercheParMarqueComponent } from './recherche-par-marque/recherche-par-marque.component';
import { RechercheParNomComponent } from './recherche-par-nom/recherche-par-nom.component';
import { ListeMarquesComponent } from './liste-marques/liste-marques.component';
import { ListeUsersComponent } from './liste-users/liste-users.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { PcGuard } from './pc.guard';

const routes: Routes = [
  {path: "pcs", component : PcsComponent},
  {path: "add-pc", component : AddPcComponent,canActivate:[PcGuard]},
  {path: "", redirectTo: "pcs", pathMatch: "full" },
  {path: "updatePc/:id", component: UpdatePcComponent},
  {path: "rechercheParUser", component : RechercheParUserComponent},
  {path: "rechercheParMarque", component : RechercheParMarqueComponent},
  {path: "rechercheParNom", component : RechercheParNomComponent},
  {path: "listeUsers", component : ListeUsersComponent},
  {path: "listeMarques", component : ListeMarquesComponent},
  {path: 'login', component: LoginComponent},
  {path: 'app-forbidden', component: ForbiddenComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
