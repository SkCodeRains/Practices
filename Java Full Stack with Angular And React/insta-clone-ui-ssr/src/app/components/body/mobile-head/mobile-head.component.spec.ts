import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MobileHeadComponent } from './mobile-head.component';

describe('MobileHeadComponent', () => {
  let component: MobileHeadComponent;
  let fixture: ComponentFixture<MobileHeadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MobileHeadComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MobileHeadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
