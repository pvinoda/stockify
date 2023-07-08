import { Component, OnInit, ElementRef } from '@angular/core';
import { Chart } from 'chart.js';
import { StockPrice } from 'src/app/models/StockPrice';

import { Comparison } from '../../models/Comparison';
import { StockPriceService } from '../../services/stock-price.service';

@Component({
  selector: 'app-comparison-charts',
  templateUrl: './comparison-charts.component.html',
  styleUrls: ['./comparison-charts.component.css'],
})
export class ComparisonChartsComponent implements OnInit {
  chart: any = [];
  //show: boolean = false;

  comparison: Comparison = {
    companyname: '',
    exchangename: '',
    fromperiod: '',
    toperiod: '',
    periodicity: '',
  };
  stockprices: StockPrice[];
  constructor(
    private stockPriceService: StockPriceService,
    private elementRef: ElementRef
  ) {}

  ngOnInit(): void {}

  onSubmit({ value, valid }: { value: Comparison; valid: boolean }) {
    if (!valid) {
    } else {
      //  console.log(value);
      this.stockPriceService
        .getCompanyStockPrices(value)
        .subscribe((response) => {
          console.log(response);
          let prices = response.map((res) => res.shareprice);
          let dates = response.map((res) => res.datee);
          let tim = response.map((res) => res.timee);
          console.log(prices);
          console.log(dates);
          //this.show = true;
          let htmlRef =
            this.elementRef.nativeElement.querySelector('#canvasId');
          console.log(htmlRef);

          this.chart = new Chart(htmlRef, {
            type: 'line',
            data: {
              labels: tim,
              datasets: [
                {
                  label: 'Pay By Person',
                  backgroundColor: 'rgba(0, 129, 214, 0.8)',
                  data: prices,
                },
              ],
            },
            options: {
              legend: {
                display: false,
                position: 'top',
              },
              scales: {
                yAxes: [
                  {
                    display: true,
                  },
                ],
              },
            },
          });
        });
      console.log(this.chart);
    }
  }
}
