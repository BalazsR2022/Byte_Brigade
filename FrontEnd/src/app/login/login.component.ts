import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { BaseService } from '../base.service';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  url = 'http://localhost:8080/'
  loginForm !: FormGroup;
  loginUser: any = {}
  users: any = new BehaviorSubject<any>(null);
  constructor(private auth: AuthService, private formBuilder: FormBuilder, private base: BaseService, private router: Router, private http: HttpClient) {
    this.initUsers();
  }

  initUsers() {
    let urlGet = this.url + "users";
    this.http.get(urlGet).subscribe((data) => {
      this.users.next(data);
      console.log(data);
    });
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      user: [''],
      pass: ['']
    });
  }

  login() {
    console.log(this.users);
    for (let i = 0; this.users.getValue().length; i++) {
      if (this.users.getValue()[i].username == this.loginUser.email&&this.users.getValue()[i].role=="ADMIN_ROLE") { 
        console.log(this.users.getValue()[i].username)
        console.log("huhuhuhuhuhu: " + i);
        this.router.navigateByUrl('/booksadmin');
       }
       else if (this.users.getValue()[i].username == this.loginUser.email&&this.users.getValue()[i].role=="USER_ROLE") { 
        console.log(this.users.getValue()[i].username)
        console.log("huhuhuhuhuhu: " + i);
        window.location.assign('/home');
       }
       else{
        window.location.assign('/signup');
       }
    }

    if (this.users) {
      
    }
    else {
      // Sikertelen belépés
    }

    // let user = this.loginForm.value.user;
    // let pass = this.loginForm.value.pass;
    // let email = this.loginForm.value.email;
    // this.auth.login(user, pass, email).subscribe({
    //   next: data=>{
    //     localStorage.setItem('userData', JSON.stringify(data));
    //     console.log(data);
    //   },
    //   error: err=>{
    //     console.log('Hiba a belépés során: ' + err);
    //   }
    // });

  }
}
