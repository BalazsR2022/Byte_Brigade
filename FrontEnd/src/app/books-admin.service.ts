import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BooksAdminService {
  url =  'http://172.16.16.136:5091/api/Books/'
  private booksSub= new BehaviorSubject<any>(null)
  constructor(private http:HttpClient) {
    this.loadBooks()
   }

   loadBooks(){
     this.http.get(this.url).subscribe((data)=>{
       this.booksSub.next(data)
     })
   }
   getBooks(){
      return this.booksSub
   }

   createBook(book:any){
    this.http.post(this.url, book).subscribe(()=>{this.loadBooks()})
   }
   updateBook(book:any){
    this.http.put(this.url+book.id, book).subscribe(()=>{this.loadBooks()})
   }
   deleteBook(book:any){
    this.http.delete(this.url+book.id).subscribe(()=>{this.loadBooks()})
   }

}
