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


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    BulmaCardComponent,
    BulmaFooterComponent,
    ServiceComponent,
    HomeComponent,
    ContactComponent
  ],
  imports: [
    BrowserModule,
    MatCardModule,
    MatToolbarModule,
    HttpClientModule,
    AppRoutingModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
