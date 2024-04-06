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
  constructor(private base: BaseService) {

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
