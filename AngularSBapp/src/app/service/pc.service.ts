import { Injectable } from '@angular/core';
import { Pc } from '../model/pc.model';
import { Marque } from '../model/marque.model';
import { User } from '../model/user.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { apiURL } from '../config';
import { UserWrapper } from '../model/userWrapped.model';
import { MarqueWrapper } from '../model/marqueWrapped.model';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
}
@Injectable({
  providedIn: 'root'
})
export class PcService {
  apiURLUser: string = 'http://localhost:8010/projet/user';
  apiURLMarque: string = 'http://localhost:8010/projet/marque';
  marques: Marque[];
  users: User[];
  pcs: Pc[] = [];
  // pc :Pc;

  constructor(private http: HttpClient) {
    this.users = [
      {
        idUser: 1,
        nomUser: "Balkiss",
        emailUser: "balkis@gmail.com",
      },
      {
        idUser: 2,
        nomUser: "user2",
        emailUser: "user2@gmail.com",
      },
    ];

    this.marques = [
      {
        idMarque: 1,
        nomMarque: "Lenovo",
        paysMarque: "China",
        anneeCMarque: 1984
      },
      {
        idMarque: 2,
        nomMarque: "Dell",
        paysMarque: "United States",
        anneeCMarque: 1984
      },
      {
        idMarque: 3,
        nomMarque: "HP",
        paysMarque: "United States",
        anneeCMarque: 1939
      }
    ];
    /* this.pcs = [
        {
          idPc: 1, processeurPc: "Intel i3",
          nomPc: "Lenovo",
          memoirePc: 8,
          disqueDurPc: 248,
          prixPc: 800
        },
  
        {
          idPc: 2, processeurPc: "Intel i5",
          nomPc: "MSI",
          memoirePc: 8,
          disqueDurPc: 512,
          prixPc: 2700.0
        },
  
        {
          idPc: 3,
          processeurPc: "Intel i7",
          nomPc: "Asus TUF",
          memoirePc: 16,
          disqueDurPc: 1024,
          prixPc: 3600.0
        },
        {
          idPc: 4,
          processeurPc: "Intel i7",
          nomPc: "Asus TUF",
          memoirePc: 16,
          disqueDurPc: 1024,
          prixPc: 3600.0
        }
      ];*/
  }
  listePcs(): Observable<Pc[]> {
    return this.http.get<Pc[]>(apiURL);
  }
  ajouterPc(p: Pc): Observable<Pc> {
    return this.http.post<Pc>(apiURL, p, httpOptions);
  }
  supprimerPc(id: number) {
    const url = `${apiURL}/${id}`;
    return this.http.delete(url, httpOptions);
  }

  consulterPc(id: number): Observable<Pc> {
    const url = `${apiURL}/${id}`;
    return this.http.get<Pc>(url);
  }
  updatePc(p: Pc): Observable<Pc> {
    return this.http.put<Pc>(apiURL, p, httpOptions);
  }
  trierPcs() {
    this.pcs.sort((p1, p2) => p1.idPc! - p2.idPc!);
  }


  listeUsers(): Observable<UserWrapper> {
    return this.http.get<UserWrapper>(this.apiURLUser);
  }

  listeMarques(): Observable<MarqueWrapper> {
    return this.http.get<MarqueWrapper>(this.apiURLMarque);
  }
  consulterUser(id: number): User {
    return this.users.find(u => u.idUser == id)!;
  }
  consulterMarque(id: number): Marque {
    return this.marques.find(m => m.idMarque == id)!;
  }
  rechercherParUser(idUser: number): Observable<Pc[]> {
    const url = `${apiURL}/pcUser/${idUser}`;
    return this.http.get<Pc[]>(url);
  }

  rechercherParMarque(idMarque: number): Observable<Pc[]> {
    const url = `${apiURL}/pcMarque/${idMarque}`;
    return this.http.get<Pc[]>(url);
  }

  rechercherParNom(nom: string): Observable<Pc[]> {
    const url = `${apiURL}/pcsByName/${nom}`;
    return this.http.get<Pc[]>(url);
  }

  ajouterUser(u: User): Observable<User> {
    return this.http.post<User>(this.apiURLUser, u, httpOptions);
  }
  ajouterMarque(m: Marque): Observable<Marque> {
    return this.http.post<Marque>(this.apiURLMarque, m, httpOptions);
  }

}