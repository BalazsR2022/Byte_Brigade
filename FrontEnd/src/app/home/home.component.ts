import { Component, OnInit } from '@angular/core';
import { BaseService } from '../base.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  jsonData: any;
  constructor(private base : BaseService){
  }
  ngOnInit(): void {
    this.base.getBooks().subscribe({
      next:(data)=>{
        this.jsonData=data;
        console.log(this.jsonData);
      }
    })
  }

}
