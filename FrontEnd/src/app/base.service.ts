import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BaseService {
//url =  'http://172.16.16.136:5091/api/Books/'
//userUrl =  'http://172.16.16.136:5091/api/Users/'
url='http://localhost:8080/api/books/';
userUrl= 'http://localhost:8080/users/'
private host="http://localhost:8080/";
private bookSubject = new Subject();
private userSubject = new Subject();
  constructor(private http : HttpClient) {
    this.http=http;
    this.loadBooks();
    this.loadUsers();
    this.getUsers();
   }

   loadBooks(){
    let endpoint = "guest/books";
    let url=this.host+endpoint;
    return this.http.get(url).subscribe({
      next:(data)=>this.bookSubject.next(data),
      error:(err)=>console.log("Hiba a könyvek lekérésekor: ", err)
    });
   }

   getBooks(){
    return this.bookSubject;
   }
   
   getThisBook(id:number){
    this.loadThisBook(id);
    return this.bookSubject;
   }

   loadThisBook(id:number){
    let endpoint = "guest/books";
    let urlD=this.host+endpoint;
    return this.http.get(urlD+"/"+id).subscribe({
      next:(data)=>this.bookSubject.next(data),
      error:(err)=>console.log("Hiba a kijelölt könyv lekérésekor: ", err)
    });
   }

   postBook(body:any){
    let endpoint = "books";
    let url=this.host+endpoint;
    const result = this.http.post(url,body);
    return result;
   }

   updateBook(body:any){
    let endpoint = "books/";
    let url=this.host+endpoint+body.id;
    const result = this.http.put(url,body);
    return result;
   }

   deleteBook(id:number){
    let endpoint = "books/";
    let url=this.host+endpoint+id;
    const result = this.http.delete(url);
    return result;
   }

   loadUsers(){
    let endpoint = "users";
    let url=this.host+endpoint;
    return this.http.get(url).subscribe({
      next:(data)=>this.userSubject.next(data),
      error:(err)=>console.log("Hiba a felhasználók lekérésekor: ", err)
    });
   }

   loadThisUser(id:number){
    let endpoint = "users";
    let url=this.host+endpoint;
    return this.http.get(url+"/"+id).subscribe({
      //next:(data)=>this.bookSubject.next(data),
      next:(data)=>this.userSubject.next(data),
      error:(err)=>console.log("Hiba a kijelölt felhasználó lekérésekor: ", err)
    });
   }

   getUsers(){
    return this.userSubject;
   }

   getThisUser(){
    return this.userSubject;
   }

   postUser(body:any){
    // let endpoint = "users";
    // let url=this.host+endpoint;
    const result = this.http.post(this.userUrl,body);
    return result;
   }

   updateUser(id:number, body:any){
    // let endpoint = "users/";
    // let url=this.host+endpoint+id;
    console.log("userup",body,id)
    const result = this.http.put(this.userUrl,body);
    return result;
   }

   deleteUser(id:number){
    let endpoint = "users";
    let url=this.host+endpoint;
    const result = this.http.delete(url+"/"+id);
    return result;
   }
}
