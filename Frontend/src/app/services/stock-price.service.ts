import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import { Company } from '../models/Company';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { StockPrice } from '../models/StockPrice';
import { Comparison } from '../models/Comparison';

@Injectable({ providedIn: 'root' })
export class StockPriceService {
  url: string;
  stockpricess: StockPrice[];
  constructor(private http: HttpClient, private router: Router) {
    this.url = 'http://localhost:8080/stockprices';
  }

  public getStockPrices(): Observable<StockPrice[]> {
    return this.http.get<StockPrice[]>(this.url + '/getstockprices');
  }

  getStockPrice(id: string): Observable<StockPrice> {
    return this.http.get<StockPrice>(this.url + id);
  }

  addStockPriceList(stockPrices: StockPrice[]) {
    //console.log(stockPrices);
    this.http
      .post<StockPrice[]>(this.url + '/addstockprices', stockPrices)
      .subscribe((responseData) => {
        console.log(responseData);
      });
  }
  public getCompanyStockPrices(
    comparision: Comparison
  ): Observable<StockPrice[]> {
    return this.http.post<StockPrice[]>(
      this.url + '/compareCompany',
      comparision
    );

    //return null;
  }
  updateStockPrice(stockPrice: StockPrice) {
    this.http.put(this.url, stockPrice).subscribe((response) => {
      this.router.navigate(['/stock-prices']);
    });
  }

  deleteStockPrice(id: string) {
    this.http.delete(this.url + id).subscribe((response) => {
      this.router.navigate(['/stock-prices']);
    });
  }

  getSectorStockPrices(comparsion: Comparison) {
    return this.http.post<StockPrice[]>(
      this.url + '/compareSector',
      comparsion
    );
  }
}
