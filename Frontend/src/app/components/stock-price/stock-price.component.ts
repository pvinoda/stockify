import { Component, OnInit } from '@angular/core';
import { StockPrice } from 'src/app/models/StockPrice';
import { StockPriceService } from 'src/app/services/stock-price.service';

@Component({
  selector: 'app-stock-price',
  templateUrl: './stock-price.component.html',
  styleUrls: ['./stock-price.component.css'],
})
export class StockPriceComponent implements OnInit {
  stockPrices: StockPrice[];

  constructor(private stockpricesService: StockPriceService) {}

  ngOnInit(): void {
    this.stockpricesService.getStockPrices().subscribe((response) => {
      this.stockPrices = response;
    });
  }
}
