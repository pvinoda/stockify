import { Component, OnInit } from '@angular/core';
import { Companystockmap } from 'src/app/models/Companystockmap';
import { CompstockmapService } from 'src/app/services/compstockmap.service';

@Component({
  selector: 'app-comp-stock-map',
  templateUrl: './comp-stock-map.component.html',
  styleUrls: ['./comp-stock-map.component.css'],
})
export class CompStockMapComponent implements OnInit {
  compstockmaps: Companystockmap[];
  constructor(private compstockservice: CompstockmapService) {}

  ngOnInit(): void {
    this.compstockservice.getAllMaps().subscribe((response) => {
      this.compstockmaps = response;
      console.log(response);
    });
  }
}
