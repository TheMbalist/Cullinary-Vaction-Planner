import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteExperienceDialogComponent } from './delete-experience-dialog.component';

describe('DeleteExperienceDialogComponent', () => {
  let component: DeleteExperienceDialogComponent;
  let fixture: ComponentFixture<DeleteExperienceDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DeleteExperienceDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DeleteExperienceDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
