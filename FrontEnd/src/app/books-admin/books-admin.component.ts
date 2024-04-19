import { Component } from '@angular/core';
import { BooksAdminService } from '../books-admin.service';

@Component({
  selector: 'app-books-admin',
  templateUrl: './books-admin.component.html',
  styleUrls: ['./books-admin.component.css']
})
export class BooksAdminComponent {
oszlopok=[
  "id",
  "author",
  "category",
  "county",
  "picture",
  "publisher",
  "quality",
  "reserved",
  "title" ,
  "year", 
  "userId"
]
books:any
newBook:any={}
constructor(private bookservice:BooksAdminService){
this.bookservice.getBooks().subscribe(data=>{
  this.books=data;
})

}

createBook(){
  this.bookservice.createBook(this.newBook)
  }

updateBook(book:any){
  this.bookservice.updateBook(book)
  }
deleteBook(book:any){
  this.bookservice.deleteBook(book)
  }
}




