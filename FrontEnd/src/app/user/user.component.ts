import { Component, OnInit } from '@angular/core';
import { BaseService } from '../base.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit{
  userDatas:any;
  emptyData=true;
  passwordVisible=false;
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
}
