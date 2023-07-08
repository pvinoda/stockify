import { Time } from '@angular/common';

export interface StockPrice {
  id?: number;
  companycode?: string;
  exchangename?: string;
  shareprice?: number;
  datee?: Date;
  timee?: string;
}
