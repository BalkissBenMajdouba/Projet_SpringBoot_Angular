import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PcsComponent } from './pcs/pcs.component';
import { AddPcComponent } from './add-pc/add-pc.component';
import { FormsModule } from '@angular/forms';
import { UpdatePcComponent } from './update-pc/update-pc.component';
import { HttpClientModule } from '@angular/common/http';
import { RechercheParUserComponent } from './recherche-par-user/recherche-par-user.component';
import { RechercheParMarqueComponent } from './recherche-par-marque/recherche-par-marque.component';
import { RechercheParNomComponent } from './recherche-par-nom/recherche-par-nom.component';
import { SearchFilterPipe } from './search-filter.pipe';
import { ListeUsersComponent } from './liste-users/liste-users.component';
import { ListeMarquesComponent } from './liste-marques/liste-marques.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UpdateMarqueComponent } from './update-marque/update-marque.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';


@NgModule({
  declarations: [
    AppComponent,
    PcsComponent,
    AddPcComponent,
    UpdatePcComponent,
    RechercheParUserComponent,
    RechercheParMarqueComponent,
    RechercheParNomComponent,
    SearchFilterPipe,
    ListeUsersComponent,
    ListeMarquesComponent,
    UpdateUserComponent,
    UpdateMarqueComponent,
    LoginComponent,
    ForbiddenComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule 

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
