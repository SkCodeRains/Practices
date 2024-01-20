import { Component, TemplateRef } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RestHelperService } from '../../../rest-helper.service';
import { UserService } from '../../../services/user-service.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { DatepickerPopupComponent } from '../../tools/datepicker-popup/datepicker-popup.component';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, DatepickerPopupComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {

  newUser = { username: "", password: "", email: "", birthDate: "", person_name: "", gender: "" };
  loginUser = { username: "", password: "" }

  userForm: FormGroup<any> = this.fb.group(this.loginUser)
  login: boolean = true;
  constructor(private fb: FormBuilder,
    private rest: RestHelperService,
    private user: UserService,
    private router: Router) { }
  onSubmit() {
    if (this.login) {
      this.rest.login(this.userForm.value).subscribe({
        next: (response) => {
          this.user.token = response.token;
          this.user.logged_in = true;
          this.router.navigate(["feed"]);
        },
        error: (error) => {
          console.error(error);
        }
      });
    } else {
      this.rest.register(this.userForm.value).subscribe({
        next: (response) => {
          this.user.token = response.token;
          this.user.logged_in = true;
          this.router.navigate(["feed"]);
        },
        error: (error) => {
          console.error(error);
        }
      });
    }
  }
  toggleUserLogin() {
    this.userForm = this.fb.group(this.login ? this.newUser : this.loginUser);
    this.login = !this.login;
  }
}
