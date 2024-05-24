import { Component } from '@angular/core';
import { Pc } from '../model/pc.model';
import { Marque } from '../model/marque.model';
import { PcService } from '../service/pc.service';

@Component({
  selector: 'app-recherche-par-marque',
  templateUrl: './recherche-par-marque.component.html',
  styles: ``
})
export class RechercheParMarqueComponent {
 IdMarquee!: number;
  pcs!: Pc[];
  marques!: Marque[];
  constructor(private pcService : PcService){}
  ngOnInit(): void {
    this.pcService.listeMarques().
      subscribe(m => {
        this.marques = m._embedded.marques;
        console.log(m);
      });};
    onChange(){
      this.pcService.rechercherParMarque(this.IdMarquee).
        subscribe(m => { this.pcs = m });

    
  }



}
