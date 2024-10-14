import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantListingComponentComponent } from './restaurant-listing-component.component';

describe('RestaurantListingComponentComponent', () => {
  let component: RestaurantListingComponentComponent;
  let fixture: ComponentFixture<RestaurantListingComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RestaurantListingComponentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RestaurantListingComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
