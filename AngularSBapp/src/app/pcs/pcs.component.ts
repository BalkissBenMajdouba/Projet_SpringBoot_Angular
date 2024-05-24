import { Component, OnInit } from '@angular/core';
import { Pc } from '../model/pc.model';
import { PcService } from '../service/pc.service';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-pcs',
  templateUrl: './pcs.component.html',
  styleUrl: './pcs.component.css'
})
export class PcsComponent implements OnInit { 
  pcs?: Pc[];
  constructor(private pcService : PcService,
    public authService: AuthService) { }
  ngOnInit(): void {
    this.chargerPcs();
  }
  chargerPcs() {
    this.pcService.listePcs().subscribe(ps => {
      console.log(ps);
      this.pcs = ps;
    });
  }
  supprimerPc(p: Pc) {
    let verif = confirm("Are you sure ?");
    if (verif &&  p.idPc !== undefined)
      this.pcService.supprimerPc(p.idPc).subscribe(() => {
        console.log("Deleted with success !");
        this.chargerPcs();
      });
    else {
      console.error("ID is undefined, cannot delete the PC.");
  }


}
}