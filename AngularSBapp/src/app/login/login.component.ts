import { Component } from '@angular/core';
import { Client } from '../model/client.model';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: ``
})
export class LoginComponent {
  client = new Client();
  erreur=0;
  constructor(private authService: AuthService,
    private router: Router) { }

  onLoggedin() {
    console.log(this.client);
    let isValidClient: Boolean = this.authService.SignIn(this.client);
    if (isValidClient)
      this.router.navigate(['/']);
    else
      //alert('Login ou mot de passe incorrecte!');
      this.erreur = 1;

  }
}
