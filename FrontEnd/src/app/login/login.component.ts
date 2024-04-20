import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { BaseService } from '../base.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
    loginForm !: FormGroup;
    loginUser:any={}
    users:any=[]
    constructor(private auth:AuthService, private formBuilder: FormBuilder, private base:BaseService, private router:Router) {
      this.base.getUsers().subscribe(res=>this.users=res);
    }

    ngOnInit(): void {
        this.loginForm=this.formBuilder.group({
          user:[''],
          pass: [''],
          email: ['']
        });
    }

    login(){
      console.log(this.users)
      this.users=this.users.filter(
        (res:any)=> {
          if(res.username==this.loginUser.email)console.log(this.loginUser)
          return (res.username==this.loginUser.email && res.password==this.loginUser.password)}
      )

      if (this.users){
        this.router.navigateByUrl('')
      }
      else{
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
