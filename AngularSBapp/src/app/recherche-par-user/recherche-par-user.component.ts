import { Component, OnInit } from '@angular/core';
import { Pc } from '../model/pc.model';
import { User } from '../model/user.model';
import { PcService } from '../service/pc.service';

@Component({
  selector: 'app-recherche-par-user',
  templateUrl: './recherche-par-user.component.html',
  styles: ``
})
export class RechercheParUserComponent implements OnInit {
  IdUserr!: number;
  pcs!: Pc[];
  users!: User[];
  constructor(private pcService : PcService){}
  ngOnInit(): void {
    this.pcService.listeUsers().
      subscribe(u => {
        this.users = u._embedded.users;
        console.log(u);
      });};
    onChange(){
      this.pcService.rechercherParUser(this.IdUserr).
        subscribe(u => { this.pcs = u });

    
  }



}
