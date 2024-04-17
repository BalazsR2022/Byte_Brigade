import { Component, ElementRef } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  userForm!: FormGroup;
  userFormValid: boolean = true;

  constructor(private elRef: ElementRef) {
    this.initUserForm();
  }

  saveUserData() {
    if (this.userForm.valid) {
      console.log(this.userForm);
      this.initUserForm();
    } else {
      this.userFormValid = false;
    }
  }

  initUserForm() {
    this.userForm = new FormGroup({
      name: new FormControl('', Validators.required),
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', Validators.required),
      county: new FormControl('Megyék', Validators.required)
    });
  }

  jumpToElement() {
    const element = this.elRef.nativeElement.querySelector('#mysite');
    if (element) {
      element.scrollIntoView({ behavior: 'smooth', block: 'start' });
    }
  }
}
