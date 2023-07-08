import { Company } from "./Company";

export interface IPO {
  id?: number;
  companyName?: string;
  pricePerShare?: number;
  totalNumberOfShares?: number;
  openDateTime?: string;
  company?:Company
}
