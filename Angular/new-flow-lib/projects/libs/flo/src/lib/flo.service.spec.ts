import { TestBed } from '@angular/core/testing';

import { FloService } from './flo.service';

describe('FloService', () => {
  let service: FloService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FloService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
