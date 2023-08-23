import {Component, OnInit} from '@angular/core';
import {ClientService} from "../../services/client/client.service";

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  constructor(
    private clientService: ClientService
  ) {
  }

  ngOnInit(): void {
    this.clientService.getClients()
      .subscribe(clients => {
        console.log(`Clients from server: ${JSON.stringify(clients, null, 2)}`)
      })
  }
}
