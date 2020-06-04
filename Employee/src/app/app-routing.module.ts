import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import{HomeComponent} from './home/home.component';
import{AdminLandComponent} from './admin/admin-land/admin-land.component';
import { RegisterComponent } from './user/register/register.component';
import { SignComponent } from './user/sign/sign.component';
import { UsersComponent } from './user/users/users.component';

import { UserLandComponent } from './user/user-land/user-land.component';

import { ActivateComponent } from './user/activate/activate.component';

import { LogoutComponent } from './user/logout/logout.component';
import { LoginGuard } from './login.guard';
import { ContactusComponent } from './admin/contactus/contactus.component';
import { AboutusComponent } from './admin/aboutus/aboutus.component';
import { EmployeeDocumentComponent } from './employee-document/employee-document.component';
const routes: Routes = [{path:'', component:HomeComponent},
                        {path:'admin-land', component:AdminLandComponent,canActivate:[LoginGuard]},
                        {path:'user-land', component:UserLandComponent,canActivate:[LoginGuard]},
                        {path:'register', component: RegisterComponent},
                        {path:'sign', component: SignComponent},
                        {path:'see-users', component: UsersComponent},
                           {path:'activate' ,component:ActivateComponent},
                            {path:'logout' ,component:LogoutComponent},
                            {path:'contactus' ,component:ContactusComponent},
                            {path:'aboutus' ,component:AboutusComponent},
                            {path:'document' ,component:EmployeeDocumentComponent},
                        ];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
