import { Component, OnInit } from '@angular/core';
import { Marque } from '../model/marque.model';
import { PcService } from '../service/pc.service';

@Component({
  selector: 'app-liste-marques',
  templateUrl: './liste-marques.component.html',
  styles: ``
})
export class ListeMarquesComponent implements OnInit {
  marques!: Marque[];
  ajout: boolean = true;
  updatedMarque: Marque = { "idMarque": 0, "nomMarque": "" };

  constructor(private pcService: PcService) { }
  ngOnInit(): void {
    this.pcService.listeMarques().
      subscribe(m => {
        this.marques = m._embedded.marques;
        console.log(m);
      });
  }

  marqueUpdated(m: Marque) {
    console.log(" marque updated event", m);
    this.pcService.ajouterMarque(m).
      subscribe(() => this.chargerMarques());
  }
  chargerMarques() {
    this.pcService.listeMarques().
      subscribe(m => {
        this.marques = m._embedded.marques;
        console.log(m);
      });
  }
  updateMarque(marque: Marque) {
    this.updatedMarque = marque;
    this.ajout = false;
  }


}
