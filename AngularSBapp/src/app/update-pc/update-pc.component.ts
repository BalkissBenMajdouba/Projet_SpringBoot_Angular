import { Component, OnInit } from '@angular/core';
import { Pc } from '../model/pc.model';
import { ActivatedRoute, Router } from '@angular/router';
import { PcService } from '../service/pc.service';
import { Marque } from '../model/marque.model';
import { User } from '../model/user.model';

@Component({
  selector: 'app-update-pc',
  templateUrl: './update-pc.component.html',
  styles: ``
})
export class UpdatePcComponent implements OnInit {

  currentPc = new Pc();
  users!: User[];
  updatedUserId!: number;
  marques!: Marque[];
  updatedMarqueId!: number;
  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private pcService: PcService
  ) { }//chat
  ngOnInit(): void {
    /* this.pcService.consulterPc(this.activatedRoute.snapshot.params['id']).
     subscribe( p =>{ this.currentPc = p; } ) ;
     this.users = this.pcService.listeUsers();
     this.marques = this.pcService.listeMarques();
     this.updatedUserId=this.currentPc.user?.idUser ?? 0;
     this.updatedMarqueId=this.currentPc.marque?.idMarque ?? 0;
     onsole.log(this.currentPc);*/
    this.pcService.listeUsers().
      subscribe(usrs => {
        this.users = usrs._embedded.users;
        console.log(usrs);
      });
    this.pcService.consulterPc(this.activatedRoute.snapshot.params['id']).
      subscribe(p => {
        this.currentPc =p;
        this.updatedUserId=this.currentPc.user?.idUser?? 0;
      });
      this.pcService.listeMarques().subscribe(marques => {
        this.marques = marques._embedded.marques;
        console.log(marques);
      });

  }
  updatePc() {
    this.currentPc.user =  this.users.
    find(usrs => usrs.idUser == this.updatedUserId)!;

    this.currentPc.marque = this.marques.
    find(usrs => usrs.idMarque == this.updatedMarqueId)!;
    this.pcService.updatePc(this.currentPc).subscribe(p => {
      this.router.navigate(['pcs']);
    }
    );


  }


}
