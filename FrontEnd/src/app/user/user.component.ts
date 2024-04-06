import { Component, OnInit } from '@angular/core';
import { BaseService } from '../base.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit{
  userDatas:any;
  emptyData=true;
  passwordVisible=false;
  userForm:any;
  constructor(private base: BaseService) {

  }

  togglePassword(key: string) {
    this.passwordVisible = !this.passwordVisible;
  }

  ngOnInit(): void {
    this.base.getUsers().subscribe({
      next: (res)=>{
        this.userDatas=res;
        this.emptyData=false;
      },
      error: (err)=>{
        console.log('Hiba az oldalon: ' + err);
        this.emptyData=true;
      }
    });
  }

  deleteUser(data:any){
    this.base.deleteUser(data.id).subscribe({
      next: (res)=>{
        console.log(res);
        this.base.loadUsers();        
      },
      error: (err)=>{
        console.log('Hiba a törlés során: ' + err);
      }
    });
  }
  saveUser(){
   
  }
  
}
