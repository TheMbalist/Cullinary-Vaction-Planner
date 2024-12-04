import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItineraryModalComponent } from './itinerary-modal.component';

describe('ItineraryModalComponent', () => {
  let component: ItineraryModalComponent;
  let fixture: ComponentFixture<ItineraryModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ItineraryModalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ItineraryModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
