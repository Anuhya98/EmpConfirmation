import { Component, OnInit } from '@angular/core';
import {FormGroup , FormControl, Validators, FormBuilder} from '@angular/forms';
import { User } from 'src/models/user';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { AuthService } from 'src/app/services/auth.service';
@Component({
  selector: 'app-sign',
  templateUrl: './sign.component.html',
  styleUrls: ['./sign.component.css']
})
export class SignComponent implements OnInit {
signinForm:FormGroup;
users:User[];
  currentUser:User;
  constructor(private formBuilder:FormBuilder, private router:Router,private userService:UserService,private authService:AuthService) { }

  ngOnInit() {
    this.signinForm =this.formBuilder.group ({
      id:[],
      email: ['',[Validators.required,Validators.email]],
      password: ['',Validators.required],
      
    });

}
  onSubmit():void{
    console.log(this.signinForm.value);
    

}

login(){
  let email=this.signinForm.controls.email.value;
  let password=this.signinForm.controls.password.value;
  const result$=this.authService.authenticate(email,password);
  result$.subscribe(data=>{
    this.currentUser = data;
    console.log(data);
    alert(data.userType)
  if(data.userType=='ROLE_ADMIN'){
    
    this.router.navigate(['/admin-land']);
  }
  else{
    sessionStorage.removeItem('empId');
    sessionStorage.setItem('empId', this.currentUser.id.toString());
    this.router.navigate(['/document']);
  }
  });
}
}





// isValid(){
//   let admin_userName="admin@gmail.com";
//   let admin_password="admin";
//   let userName=this.signinForm.controls.email.value;
//   let password=this.signinForm.controls.password.value;

//   if((userName===admin_userName) && (password===admin_password)){
//     this.router.navigate(['/admin-land']);
//   }else{
//     if(this.login(userName,password)){
//       if(this.userService.isActivated(this.currentUser)){
//         localStorage.removeItem('userId');
//         localStorage.setItem('userId',this.currentUser.id.toString());
//         this.router.navigate(['/user-land']);
//       }else{
//         alert("please activate your account to login")
//       }
//     }else{
//       alert("Invalid username or password");
//       this.signinForm.reset();
//     }
//   }

// }

// login(userName:string,password:string){
//   for(let user of this.users){
//     if((userName===user.email)&&(password===user.password)){
//       this.currentUser=user;
//       return true;

//     }
//   }
//   return false;
// }

