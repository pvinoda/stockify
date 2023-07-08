import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompStockMapComponent } from './comp-stock-map.component';

describe('CompStockMapComponent', () => {
  let component: CompStockMapComponent;
  let fixture: ComponentFixture<CompStockMapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompStockMapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompStockMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
