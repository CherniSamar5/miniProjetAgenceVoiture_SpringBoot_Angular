import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-voitures',
  templateUrl: './voitures.component.html',
  styleUrls: ['./voitures.component.css']
})
export class VoituresComponent implements OnInit {
  voitures!  : string[]

  constructor() {
    this.voitures = ["GOLF7", "Megane" ,"Clio4"];
    }

  ngOnInit(): void {
  }

}
