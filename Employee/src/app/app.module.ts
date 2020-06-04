import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './user/register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { SignComponent } from './user/sign/sign.component';
import { UsersComponent } from './user/users/users.component';

import { AdminLandComponent } from './admin/admin-land/admin-land.component';

import { ActivateComponent } from './user/activate/activate.component';


import { LogoutComponent } from './user/logout/logout.component';
import { HttpInterceptorService } from './services/http-interceptor.service';
import { ContactusComponent } from './admin/contactus/contactus.component';
import { AboutusComponent } from './admin/aboutus/aboutus.component';

import { EmployeeDocumentComponent } from './employee-document/employee-document.component';
import { UserLandComponent } from './user/user-land/user-land.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegisterComponent,
    SignComponent,
    UsersComponent,
    AdminLandComponent,
    UserLandComponent,
    ActivateComponent,
    LogoutComponent,
    ContactusComponent,
    AboutusComponent,
    EmployeeDocumentComponent,
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    }

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
