import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class BooksAdminService {
  //url =  'http://172.16.16.136:5091/api/Books/'
  url='http://localhost:8080/'
  private booksSub= new BehaviorSubject<any>(null)
  constructor(private http:HttpClient, private base: BaseService) {
    this.loadBooks()
   }

   loadBooks(){
    let urlGet=this.url+"guest/books";
     this.http.get(urlGet).subscribe((data)=>{
       this.booksSub.next(data)
     })
   }
   getBooks(){
      return this.booksSub
   }

   createBook(book:any){
    this.base.postBook(book).subscribe((res)=>{
      console.log(res);
      this.loadBooks();
    })
   }
   updateBook(book:any){
    this.http.put(this.url+"/"+book.id, book).subscribe(()=>{this.loadBooks()})
   }
   deleteBook(book:any){
    console.log(book.id)
    this.base.deleteBook(book.id).subscribe((res)=>{
      console.log(res)
      this.loadBooks()
    })
    //this.http.delete(this.url+"/"+book.id).subscribe(()=>{this.loadBooks()})
   }

}
