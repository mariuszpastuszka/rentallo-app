import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './components/app/app.component';
import { CarsComponent } from './components/cars/cars.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule} from "@angular/common/http";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import { TopBarComponent } from './components/top-bar/top-bar.component';
import { NavigationBarComponent } from './components/navigation-bar/navigation-bar.component';
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import { ClientsComponent } from './components/clients/clients.component';
import { AboutComponent } from './components/about/about.component';
import { RentsHistoryComponent } from './components/rents-history/rents-history.component';
import { RouterModule, Routes} from "@angular/router";
import {aboutUrl, carsUrl, clientsUrl, homePageUrl, notFoundPageUrl, rentsHistoryUrl} from "./models/urls";
import { HomeComponent } from './components/home/home.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import {MatIconModule} from "@angular/material/icon";
import {MatInputModule} from "@angular/material/input";
import {MatTableModule} from "@angular/material/table";
import {MatSortModule} from "@angular/material/sort";
import {MatPaginatorModule} from "@angular/material/paginator";
import {ReactiveFormsModule} from "@angular/forms";
import {authGuard} from "./services/login/login.service";
import {
  AuthConfig,
  JwksValidationHandler, OAuthModule,
  OAuthModuleConfig,
  OAuthStorage,
  ValidationHandler
} from "angular-oauth2-oidc";

const routingTable: Routes = [
  {path: homePageUrl, component: HomeComponent},
  {path: rentsHistoryUrl, component: RentsHistoryComponent, canActivate: [authGuard]},
  {path: carsUrl, component: CarsComponent},
  {path: clientsUrl, component: ClientsComponent, canActivate: [authGuard]},
  {path: aboutUrl, component: AboutComponent},
  {path: notFoundPageUrl, component: NotFoundComponent}
]

const config: AuthConfig = {
  issuer: 'http://localhost:9001/',
  dummyClientSecret: 'secret',
  clientId: 'rentallo-app',
  disablePKCE: true,
  responseType: 'code',
  oidc: true,
  requireHttps: false,
  strictDiscoveryDocumentValidation: false,
  redirectUri: 'http://localhost:4200',
  silentRefreshRedirectUri: window.location.origin + '/silent-refresh.html',
  scope: 'openid management',
  requestAccessToken: true,
  skipIssuerCheck: true,
  showDebugInformation: true,
  logoutUrl: 'http://localhost:4200'
};

const authModuleConfig: OAuthModuleConfig = {
  // Add the Bearer header for these URLs (APIs).
  resourceServer: {
    allowedUrls: ['http://localhost:8080'],
    sendAccessToken: true,
  },
};

@NgModule({
  declarations: [
    AppComponent,
    CarsComponent,
    TopBarComponent,
    NavigationBarComponent,
    ClientsComponent,
    AboutComponent,
    RentsHistoryComponent,
    HomeComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatCardModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatIconModule,
    RouterModule.forRoot(routingTable),
    MatInputModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    OAuthModule.forRoot(authModuleConfig),
    ReactiveFormsModule
  ],
  providers: [
    { provide: OAuthModuleConfig, useValue: authModuleConfig },
    { provide: ValidationHandler, useClass: JwksValidationHandler },
    { provide: OAuthStorage, useValue: localStorage },
    { provide: AuthConfig, useValue: config },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
