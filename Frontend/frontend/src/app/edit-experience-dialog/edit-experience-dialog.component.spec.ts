import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditExperienceDialogComponent } from './edit-experience-dialog.component';

describe('EditExperienceDialogComponent', () => {
  let component: EditExperienceDialogComponent;
  let fixture: ComponentFixture<EditExperienceDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditExperienceDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditExperienceDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
