import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { PcService } from '../service/pc.service';

@Component({
  selector: 'app-liste-users',
  templateUrl: './liste-users.component.html',
  styles: ``
})
export class ListeUsersComponent implements OnInit {
  users!: User[];
  ajout: boolean = true;
  updatedUser: User = { "idUser": 0, "nomUser": "" };

  constructor(private pcService: PcService) { }
  ngOnInit(): void {
    this.pcService.listeUsers().
      subscribe(u => {
        this.users = u._embedded.users;
        console.log(u);
      });
  }
  userUpdated(u: User) {
    console.log("user updated event", u);
    this.pcService.ajouterUser(u).
      subscribe(() => this.chargerUsers());
  }
  chargerUsers() {
    this.pcService.listeUsers().
      subscribe(u => {
        this.users = u._embedded.users;
        console.log(u);
      });
  }
  updateUser(user: User) {
    this.updatedUser = user;
    this.ajout=false;
  }
}
