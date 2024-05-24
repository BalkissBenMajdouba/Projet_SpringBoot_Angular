import { Component, OnInit } from '@angular/core';
import { AuthService } from './service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'AngularSBapp';
  constructor(public authService: AuthService, private router : Router ) { }
  ngOnInit(): void {
    
      let isloggedin : string;
      let loggedClient:string;
      isloggedin = localStorage.getItem('isloggedIn')?? '';
      loggedClient = localStorage.getItem('loggedClient')?? '';
      if (isloggedin!="true" || !loggedClient)
      this.router.navigate(['/login']);
      else
      this.authService.setLoggedClientFromLocalStorage(loggedClient);
        }

  onLogout() {
    this.authService.logout();
  }
 
}
