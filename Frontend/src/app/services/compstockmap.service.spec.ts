import { TestBed } from '@angular/core/testing';

import { CompstockmapService } from './compstockmap.service';

describe('CompstockmapService', () => {
  let service: CompstockmapService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CompstockmapService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
