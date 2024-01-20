import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MobileFootComponent } from './mobile-foot.component';

describe('MobileFootComponent', () => {
  let component: MobileFootComponent;
  let fixture: ComponentFixture<MobileFootComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MobileFootComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MobileFootComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
