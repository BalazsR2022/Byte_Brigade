import { Component, OnInit } from '@angular/core';
import { BaseService } from '../base.service';

@Component({
  selector: 'app-surprise',
  templateUrl: './surprise.component.html',
  styleUrls: ['./surprise.component.css']
})
export class SurpriseComponent implements OnInit{
  booksData:any;
  emptyData=false;
  constructor(private base:BaseService){}

  ngOnInit(): void {
    this.base.getBooks().subscribe({
      next: (res)=>{
        this.booksData=res;
        this.emptyData=false;
      },
      error: (err)=>{
        console.log('Hiba az oldalon: ' + err);
        this.emptyData=true;
      }
    });
  }

}
