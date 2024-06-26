import { Component } from '@angular/core';
import { BooksAdminService } from '../books-admin.service';

@Component({
  selector: 'app-books-admin',
  templateUrl: './books-admin.component.html',
  styleUrls: ['./books-admin.component.css']
})
export class BooksAdminComponent {
  show=false;
  private code="almafa12";
  userCode="";
  buttonText="Validál";
oszlopok=[
  {key:"id",text:"id", type:"plain"},
  {key:"author",text:"Szerző", type:"text"},
  {key:"category",text:"Kategória", type:"text"},
 {key:"county",text:"Megye", type:"text"},
  {key:"picture",text:"Kép cim", type:"text"},
 {key: "publisher",text:"Kiadó", type:"text"},
  {key:"quality",text:"Állapot", type:"text"},
  {key:"reserved",text:"Foglalt", type:"bool"},
  {key:"title" ,text:"Cím", type:"text"},
  {key:"year",text:"Év", type:"number"},
 {key:"userId",text:"UserId", type:"number"},
]
oszlopok2=[
  {key:"id",text:"id", type:"plain"},
  {key:"author",text:"Szerző", type:"text"},
  {key:"category",text:"Kategória", type:"text"},
 {key:"county",text:"Megye", type:"text"},
  {key:"picture",text:"Kép cim", type:"text"},
 {key: "publisher",text:"Kiadó", type:"text"},
  {key:"quality",text:"Állapot", type:"text"},
  {key:"reserved",text:"Foglalt", type:"plain"},
  {key:"title" ,text:"Cím", type:"text"},
  {key:"year",text:"Év", type:"number"},
 {key:"userId",text:"UserId", type:"number"},
]
books:any
newBook:any={}
constructor(private bookservice:BooksAdminService){
this.bookservice.getBooks().subscribe(data=>{
  this.books=data;
})

}

createBook(){
  this.newBook.id=null;
  this.newBook.reserved=false;
  console.log(this.newBook)
  this.bookservice.createBook(this.newBook)
  }

updateBook(book:any){
  console.log(book);
  this.bookservice.updateBook(book);
  }
  
deleteBook(book:any){
  this.bookservice.deleteBook(book);
  }

  validate(){
    if(this.buttonText=="Lezár"){
      this.show=false;
      this.buttonText="Validál";
    }
    if(this.userCode==this.code){
      this.show=true;
      this.userCode="";
      this.buttonText="Lezár";
    }
    
  }
}




