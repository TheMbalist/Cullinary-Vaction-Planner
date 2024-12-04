import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IteneraryComponent } from './itenerary.component';

describe('IteneraryComponent', () => {
  let component: IteneraryComponent;
  let fixture: ComponentFixture<IteneraryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IteneraryComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(IteneraryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
