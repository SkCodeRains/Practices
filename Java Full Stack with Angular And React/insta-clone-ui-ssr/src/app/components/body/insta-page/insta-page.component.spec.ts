import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstaPageComponent } from './insta-page.component';

describe('InstaPageComponent', () => {
  let component: InstaPageComponent;
  let fixture: ComponentFixture<InstaPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InstaPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(InstaPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
