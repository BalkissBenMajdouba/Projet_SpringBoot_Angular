import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { User } from '../model/user.model';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styles: ``
})
export class UpdateUserComponent implements OnInit {
  @Input()
  user!: User;
  @Output()
  userUpdated = new EventEmitter<User>();
  @Input()
  ajout!:boolean;
  
  constructor() { }

  ngOnInit(): void {
    console.log("ngOnInit du composant UpdateUser ", this.user);
  }

  saveUser() {
    this.userUpdated.emit(this.user);
  }

}
