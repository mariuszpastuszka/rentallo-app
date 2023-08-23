import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Client} from "../../models/client";
import {allClientsUrl} from "../../models/urls";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getClients(): Observable<Array<Client>> {
    return this.httpClient.get<Array<Client>>(allClientsUrl)
  }
}
