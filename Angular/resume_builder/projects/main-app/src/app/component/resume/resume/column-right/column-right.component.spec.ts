import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColumnRightComponent } from './column-right.component';

describe('ColumnRightComponent', () => {
  let component: ColumnRightComponent;
  let fixture: ComponentFixture<ColumnRightComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ColumnRightComponent]
    });
    fixture = TestBed.createComponent(ColumnRightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
