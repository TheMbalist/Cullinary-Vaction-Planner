import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItineraryFormComponent } from './itinerary-form.component';

describe('ItineraryFormComponent', () => {
  let component: ItineraryFormComponent;
  let fixture: ComponentFixture<ItineraryFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ItineraryFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ItineraryFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
