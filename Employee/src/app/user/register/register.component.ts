import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms'
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm:FormGroup;
  users:User[];
  constructor(private formBuilder:FormBuilder, private userService:UserService , private router:Router) { }
  
  ngOnInit() {
    this.registerForm=this.formBuilder.group({
      id:[],
      name: ['',Validators.required],
      email: ['',[Validators.required,Validators.email]],
      password: ['',Validators.required],
      cpassword: ['',Validators.required],
      business_unit: ['',Validators.required],
      empId: ['',Validators.required]
     });
     this.userService.getAllUsers().subscribe(u =>{this.users=u;})
  }

 
  emailVaild(e:String){
    for(let user of this.users)
    {
      if(user.email===e){
        return false;
      }
      }
      return true;
  }
  

  addUser(){
    let e=this.registerForm.controls.email.value;
    if(this.emailVaild(e)){
    this.userService.saveUser(this.registerForm.value).subscribe(data => {
       alert('User Inserted Successfully' +data);
       alert('coming status'+data.regstatus);
       alert('Registered Successfully')
       this.registerForm.reset()
      }); }
      else
      {
        alert('already Email exsits')
        this.registerForm.reset()
      }
    
   }
   
   deleteUser(){
     this.userService.deleteUser(this.registerForm.value).subscribe(data=>{
       alert('User Deleted Successfully' +data);
      });
   } 



}