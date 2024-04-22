import { Component, OnInit } from '@angular/core';
import { BaseService } from '../base.service';
import { BooksAdminService } from '../books-admin.service';



@Component({
  selector: 'app-bulma-card',
  templateUrl: './bulma-card.component.html',
  styleUrls: ['./bulma-card.component.css']
})
export class BulmaCardComponent implements OnInit {
  jsonData: any;
  emptyData =true;
  filter!:string;
  constructor(private base: BaseService, private bookservice:BooksAdminService) {
    this.base.getBooks().subscribe({
      next: (res)=>{
        this.jsonData=res;
        this.emptyData=false;

      },
      error: (err)=>{
        console.log('Hiba az oldalon: ' + err);
        this.emptyData=true;
      }
    });
  }

  ngOnInit(): void {
    /*const filePath = "../assets/konyvek.json";
    this.jsonReadService.readJsonFile(filePath).subscribe({
      next: resp => this.jsonData = resp,
      error: err => console.error(err)
    });*/

    this.base.getBooks().subscribe({
      next: (res)=>{
        this.jsonData=res;
        this.emptyData=false;

      },
      error: (err)=>{
        console.log('Hiba az oldalon: ' + err);
        this.emptyData=true;
      }
    });
}
reservedBook(book:any){
  book.reserved=true;
  this.updateBook(book)
}

updateBook(book:any){
  this.bookservice.updateBook(book);
  }
}
