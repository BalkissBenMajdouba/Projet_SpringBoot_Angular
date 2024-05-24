import { Component, OnInit } from '@angular/core';
import { PcService } from '../service/pc.service';
import { Pc } from '../model/pc.model';

@Component({
  selector: 'app-recherche-par-nom',
  templateUrl: './recherche-par-nom.component.html',
  styles: ``
})
export class RechercheParNomComponent implements OnInit{
  nomPc!: string;
  pcs!: Pc[];  
  allPcs! : Pc[];
  searchTerm!: string;

  constructor(private pcService: PcService) { }
  ngOnInit(): void {
    this.pcService.listePcs().subscribe(p => {
      console.log(p);
      this.allPcs = p;
      });
  }
  onKeyUp(filterText : string){
    this.pcs = this.allPcs.filter(item =>
    item.nomPc?.toLowerCase().includes(filterText));
    }

  rechercherPcs() {
    this.pcService.rechercherParNom(this.nomPc).
      subscribe(pcs => {
        this.pcs = pcs;
        console.log(pcs)
      });
  }

}
