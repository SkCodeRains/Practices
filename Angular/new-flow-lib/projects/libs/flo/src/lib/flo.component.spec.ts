import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FloComponent } from './flo.component';

describe('FloComponent', () => {
  let component: FloComponent;
  let fixture: ComponentFixture<FloComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FloComponent]
    });
    fixture = TestBed.createComponent(FloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
