import { Component, OnInit } from '@angular/core';
import { JsonReaderService } from '../json-reader.service';


@Component({
  selector: 'app-bulma-card',
  templateUrl: './bulma-card.component.html',
  styleUrls: ['./bulma-card.component.css']
})
export class BulmaCardComponent implements OnInit {
  jsonData: any[] = [];
  constructor(private jsonReadService: JsonReaderService) {

  }

  ngOnInit(): void {
    const filePath = "../assets/konyvek.json";
    this.jsonReadService.readJsonFile(filePath).subscribe({
      next:resp =>this.jsonData=resp,
      error:err=>console.error(err)
    });
  }
}
