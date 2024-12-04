import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateExperienceComponent } from './create-experience.component';

describe('CreateExperienceComponent', () => {
  let component: CreateExperienceComponent;
  let fixture: ComponentFixture<CreateExperienceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateExperienceComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CreateExperienceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
