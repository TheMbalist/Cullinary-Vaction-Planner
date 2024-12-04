import { TestBed } from '@angular/core/testing';

import { ItineraryitemsService } from './itineraryitems.service';

describe('ItineraryitemsService', () => {
  let service: ItineraryitemsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ItineraryitemsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
