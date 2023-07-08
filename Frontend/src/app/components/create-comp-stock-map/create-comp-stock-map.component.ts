import { Component, OnInit } from '@angular/core';
import { Companystockmap } from '../../models/Companystockmap';
import { CompstockmapService } from '../../services/compstockmap.service';
@Component({
  selector: 'app-create-comp-stock-map',
  templateUrl: './create-comp-stock-map.component.html',
  styleUrls: ['./create-comp-stock-map.component.css'],
})
export class CreateCompStockMapComponent implements OnInit {
  compstockmap: Companystockmap = {
    companycode: '',
    companyname: '',
    stockexchangename: '',
  };
  constructor(private compstockservice: CompstockmapService) {}

  ngOnInit(): void {}

  onSubmit({ value, valid }: { value: Companystockmap; valid: boolean }) {
    console.log(value);
    if (!valid) {
    } else {
      this.compstockservice.addMapping(value);
    }
  }
}
