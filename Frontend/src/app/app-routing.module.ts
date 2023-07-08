import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AuthGuard } from './guards/auth.guard';

import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { CompaniesComponent } from './components/companies/companies.component';
import { CreateCompanyComponent } from './components/companies/create-company/create-company.component';
import { IposComponent } from './components/ipos/ipos.component';
import { CreateIpoComponent } from './components/ipos/create-ipo/create-ipo.component';
import { StockExchangesComponent } from './components/stock-exchanges/stock-exchanges.component';
import { CreateStockExchangeComponent } from './components/stock-exchanges/create-stock-exchange/create-stock-exchange.component';
import { ImportExcelComponent } from './components/import-excel/import-excel.component';
import { ComparisonChartsComponent } from './components/comparison-charts/comparison-charts.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { SectorsComponent } from './components/sectors/sectors.component';
import { CreateSectorComponent } from './components/sectors/create-sector/create-sector.component';
import { CreateCompStockMapComponent } from './components/create-comp-stock-map/create-comp-stock-map.component';
import { CompStockMapComponent } from './components/comp-stock-map/comp-stock-map.component';
import { StockPriceComponent } from './components/stock-price/stock-price.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'companies', component: CompaniesComponent },
  { path: 'create-company', component: CreateCompanyComponent },
  { path: 'ipos', component: IposComponent },
  { path: 'create-ipo', component: CreateIpoComponent },
  { path: 'stock-exchanges', component: StockExchangesComponent },
  { path: 'create-stock-exchange', component: CreateStockExchangeComponent },
  { path: 'sectors', component: SectorsComponent },
  { path: 'create-sector', component: CreateSectorComponent },
  { path: 'import-excel', component: ImportExcelComponent },
  { path: 'comparison-charts', component: ComparisonChartsComponent },
  { path: 'comp-stock-map', component: CompStockMapComponent },
  { path: 'create-comp-stock-map', component: CreateCompStockMapComponent },
  { path: 'stock-prices', component: StockPriceComponent },
  { path: '**', component: NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [AuthGuard],
})
export class AppRoutingModule {}
