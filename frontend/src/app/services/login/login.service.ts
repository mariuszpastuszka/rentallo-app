import { Injectable } from '@angular/core';
import {OAuthErrorEvent, OAuthService} from "angular-oauth2-oidc";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  loggedIn: boolean = true
  userRole: string = 'USER' // ADMIN/USER
  username = '';
  isLogged(): boolean {
    return this.oauthService.getAccessToken() !== null;
  }

  isAdmin(): boolean {
    return this.isLogged() && this.userRole === 'ADMIN'
  }

  isUser(): boolean {
    return this.isLogged() && this.userRole === 'USER'
  }
  constructor(private oauthService: OAuthService) {
    // For debugging:
    oauthService.events.subscribe(e => e instanceof OAuthErrorEvent ? console.error(e) : console.warn(e));

    // Load information from Auth0 (could also be configured manually)
    // @ts-ignore
    oauthService.loadDiscoveryDocument()

      // See if the hash fragment contains tokens (when user got redirected back)
      .then(() => oauthService.tryLogin())

      // Get username, if possible.
      .then(() => {
        if (oauthService.getIdentityClaims()) {
          this.username = oauthService.getIdentityClaims()['name'];
        }
      });

    oauthService.setupAutomaticSilentRefresh();
  }

  login() {
    this.oauthService.initCodeFlow();
  }
  logout() {
    this.oauthService.logOut();
  }
  refresh() {
    this.oauthService.silentRefresh();
  }
}

export const authGuard = () => false
