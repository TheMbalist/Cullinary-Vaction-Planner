import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditItineraryDialogComponent } from './edit-itinerary-dialog.component';

describe('EditItineraryDialogComponent', () => {
  let component: EditItineraryDialogComponent;
  let fixture: ComponentFixture<EditItineraryDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditItineraryDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditItineraryDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
