import { Component } from '@angular/core';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent {
giveBook(){
  window.location.assign("/booksadmin");
}

readBook(){
  window.location.assign("/home");
}
}
