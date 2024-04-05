import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
    loginForm !: FormGroup;
    constructor(private auth:AuthService, private formBuilder: FormBuilder){}

    ngOnInit(): void {
        this.loginForm=this.formBuilder.group({
          user:[''],
          pass: ['']
        });
    }

    login(){
      let user = this.loginForm.value.user;
      let pass = this.loginForm.value.pass;
      this.auth.login(user, pass).subscribe({
        next: data=>{
          localStorage.setItem('userData', JSON.stringify(data));
        },
        error: err=>{
          console.log('Hiba a belépés során: ' + err);
        }
      })
    }
}
