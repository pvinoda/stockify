import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateCompStockMapComponent } from './create-comp-stock-map.component';

describe('CreateCompStockMapComponent', () => {
  let component: CreateCompStockMapComponent;
  let fixture: ComponentFixture<CreateCompStockMapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateCompStockMapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateCompStockMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
