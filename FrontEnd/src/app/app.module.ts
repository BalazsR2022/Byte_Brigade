import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatToolbarModule } from  '@angular/material/toolbar';
import { MatCardModule } from "@angular/material/card";
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BulmaCardComponent } from './bulma-card/bulma-card.component';
import { BulmaFooterComponent } from './bulma-footer/bulma-footer.component';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { ServiceComponent } from './service/service.component';
import { HomeComponent } from './home/home.component';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';
import { SignupComponent } from './signup/signup.component';
import { SurpriseComponent } from './surprise/surprise.component';
import { RedbuttonComponent } from './redbutton/redbutton.component';
import { UserComponent } from './user/user.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    BulmaCardComponent,
    BulmaFooterComponent,
    ServiceComponent,
    HomeComponent,
    ContactComponent,
    AboutComponent,
    SignupComponent,
    SurpriseComponent,
    RedbuttonComponent,
    UserComponent,


  ],
  imports: [
    BrowserModule,
    MatCardModule,
    MatToolbarModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
