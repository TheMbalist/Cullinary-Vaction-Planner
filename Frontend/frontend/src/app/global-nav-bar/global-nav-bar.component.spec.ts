import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GlobalNavBarComponent } from './global-nav-bar.component';

describe('GlobalNavBarComponent', () => {
  let component: GlobalNavBarComponent;
  let fixture: ComponentFixture<GlobalNavBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GlobalNavBarComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GlobalNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
