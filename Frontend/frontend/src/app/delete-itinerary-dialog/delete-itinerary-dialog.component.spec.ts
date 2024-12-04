import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteItineraryDialogComponent } from './delete-itinerary-dialog.component';

describe('DeleteItineraryDialogComponent', () => {
  let component: DeleteItineraryDialogComponent;
  let fixture: ComponentFixture<DeleteItineraryDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DeleteItineraryDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DeleteItineraryDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
