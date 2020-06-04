import { Component, OnInit } from '@angular/core';
import { User } from 'src/models/user';
import { UserService } from '../services/user.service';
import { numberFormat } from 'highcharts';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-document',
  templateUrl: './employee-document.component.html',
  styleUrls: ['./employee-document.component.css']
})
export class EmployeeDocumentComponent implements OnInit {
  updateUserForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private userService: UserService, private router : Router) { }

  ngOnInit() {
    this.updateUserForm = this.formBuilder.group({
      id: [],
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      cpassword: ['', Validators.required],
      empId: ['',Validators.required],
      accept:[false],
      phone:['',Validators.required],
      business_unit:['',Validators.required],
      location:['',Validators.required],
      active:['']

    });

    const id = sessionStorage.getItem('empId');
    if (+id > 0) {
      this.userService.getUserById(+id).subscribe(User => {
        this.updateUserForm.patchValue(User);
      });
    }
  }
  sign() {
    this.userService.updateUser(this.updateUserForm.value).subscribe(data => {
      this.router.navigate(['']);
      alert('thanks for your time please logout')
    },
      error => {
        alert(error);
      });
  }
}
