import { TestBed } from '@angular/core/testing';

import { ResMenuService } from './res-menu.service';

describe('ResMenuService', () => {
  let service: ResMenuService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResMenuService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
