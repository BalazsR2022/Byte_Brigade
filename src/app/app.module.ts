import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatToolbarModule } from  '@angular/material/toolbar';
import { MatCardModule } from "@angular/material/card";
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BulmaCardComponent } from './bulma-card/bulma-card.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    BulmaCardComponent
  ],
  imports: [
    BrowserModule,
    MatCardModule,
    MatToolbarModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
