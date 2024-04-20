import { Component, OnInit } from '@angular/core';
import { BaseService } from '../base.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent{
  jsonData: any;
  constructor(private base : BaseService){
    this.base.getBooks().subscribe({
      next:(data)=>{
        this.jsonData=data;
        console.log(this.jsonData);
      }
    })
  }
  

}
