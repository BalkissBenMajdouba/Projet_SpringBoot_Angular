import { Component, OnInit } from '@angular/core';
import { Pc } from '../model/pc.model';
import { Router } from '@angular/router';
import { PcService } from '../service/pc.service';
import { User } from '../model/user.model';
import { Marque } from '../model/marque.model';

@Component({
  selector: 'app-add-pc',
  templateUrl: './add-pc.component.html',
  styleUrl: './add-pc.component.css'
})
export class AddPcComponent implements OnInit {
  ngOnInit(): void {
    /*throw new Error('Method not implemented.');
    this.users = this.pcService.listeUsers();
    this.marques = this.pcService.listeMarques();
*/
    this.pcService.listeUsers().
      subscribe(user => {
        
        console.log(user);
        this.users=user._embedded.users;
      });
      this.pcService.listeMarques().
      subscribe(mq => {
        this.marques=mq._embedded.marques;
        console.log(mq);
      });

  }
  newPc = new Pc();

  users!: User[];
  newIdUser!: number;
  newUser!: User;

  marques!: Marque[];
  newIdMarque!: number;
  newMarque!: Marque;
  constructor(private pcService: PcService, private router: Router) {

  }
  addPc() {
    //console.log(this.newPc);
    this.newUser = this.pcService.consulterUser(this.newIdUser);
    this.newPc.user =  this.users.find(user => user.idUser == this.newIdUser)!;
    this.newMarque = this.pcService.consulterMarque(this.newIdMarque);
    this.newPc.marque =  this.marques.find(mq => mq.idMarque == this.newIdMarque)!;
    this.pcService.ajouterPc(this.newPc).subscribe(p => {
      console.log(p);
      this.router.navigate(['pcs']);
    });
  }
}
