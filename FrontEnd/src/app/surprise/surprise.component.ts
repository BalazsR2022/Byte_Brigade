import { Component, OnInit } from '@angular/core';
import { BaseService } from '../base.service';
import { BehaviorSubject } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-surprise',
  templateUrl: './surprise.component.html',
  styleUrls: ['./surprise.component.css']
})
export class SurpriseComponent  {
  url='http://localhost:8080/'
  object:any={};
  arrayBook:any=new BehaviorSubject<any>(null);
  thisBook:any={};
  emptyData = false;
  clicked = false;
  rand!: number;
  image:any="regény";
  constructor(private base: BaseService, private http: HttpClient) { 
    this.initBooks();
    
  }

  initBooks() {
    let urlGet=this.url+"guest/books";
     this.http.get(urlGet).subscribe((data)=>{
       this.arrayBook.next(data);
       console.log(data);
     });
     
  }

  loadSurprise() {
    if (!this.clicked){ 
      this.clicked = true;
    }
    this.rand = this.getRandomInt(0, (this.arrayBook.getValue().length - 1));
    this.object=this.arrayBook.getValue()[this.rand];
    this.image=this.object.category;
  }

  getRandomInt(min: number, max: number): number {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }
}
