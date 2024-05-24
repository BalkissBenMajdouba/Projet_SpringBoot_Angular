import { Injectable } from '@angular/core';
import { Client } from '../model/client.model';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  clients: Client[] = [{ "username": "admin", "password": "123", "roles": ['ADMIN'] },
  { "username": "balkiss", "password": "azerty", "roles": ['CLIENT'] }];

  public loggedClient!: string;
  public isloggedIn: Boolean = false;
  public roles!: string[];

  constructor(private router: Router) { }

  logout() {
    this.isloggedIn = false;
    this.loggedClient = undefined!;
    this.roles = undefined!;
    localStorage.removeItem('loggedClient');
    localStorage.setItem('isloggedIn', String(this.isloggedIn));
    this.router.navigate(['/login']);
  }

  SignIn(client :Client):Boolean{
    let validClient: Boolean = false;
    this.clients.forEach((curClient) => {
    if(client.username== curClient.username && client.password==curClient.password) {
      validClient = true;
    this.loggedClient = curClient.username;
    this.isloggedIn = true;
    this.roles = curClient.roles;
    localStorage.setItem('loggedClient',this.loggedClient);
    localStorage.setItem('isloggedIn',String(this.isloggedIn));
    }
    });
    return validClient;

    
    }
    isAdmin():Boolean{
      if (!this.roles) //this.roles== undefiened
      return false;
      return (this.roles.indexOf('ADMIN') >-1);
      }
      setLoggedClientFromLocalStorage(login : string) {
        this.loggedClient = login;
        this.isloggedIn = true;
        this.getUserRoles(login);
        }
        getUserRoles(username :string){
        this.clients.forEach((curClient) => {
        if( curClient.username == username ) {
        this.roles = curClient.roles;
        }
        });}
}
