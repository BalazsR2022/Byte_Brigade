import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-mysite',
  templateUrl: './mysite.component.html',
  styleUrls: ['./mysite.component.css']
})
export class MysiteComponent implements OnInit {
  userForm!: FormGroup;
  books: any | null = null;
  userDataLoaded: boolean = false;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.userForm = this.formBuilder.group({
      name: [''],
      email: [''],
      password: [''],
      county: [''],
      bookTitle: ['']
    });
  }

  saveUserData() {
    throw new Error('Method not implemented.');
  }
}
