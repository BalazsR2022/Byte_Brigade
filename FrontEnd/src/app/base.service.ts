import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BaseService {
private url="http://localhost:8080/books";
private bookSubject = new Subject();
  constructor(private http : HttpClient) {
    this.loadBooks();
    this.getBooks();
   }

   loadBooks(){
    return this.http.get(this.url).subscribe({
      next:(data)=>this.bookSubject.next(data),
      error:(err)=>console.log("Hiba az adatok lekérésekor: ", err)
    });
   }

   getBooks(){
    return this.bookSubject;
   }
   
   getThisBook(){
    return this.bookSubject;
   }

   loadThisBook(id:number){
    return this.http.get(this.url+"/"+id).subscribe({
      next:(data)=>this.bookSubject.next(data),
      error:(err)=>console.log("Hiba a kijelölt lekérésekor: ", err)
    });
   }

   postBook(body:any){
    const result = this.http.post(this.url,body);
    return result;
   }

   deleteBook(id:number){
    const result = this.http.delete(this.url+"/"+id);
    return result;
   }
}
