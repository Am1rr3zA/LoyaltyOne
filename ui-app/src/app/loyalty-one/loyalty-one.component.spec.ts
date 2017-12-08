import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoyaltyOneComponent } from './loyalty-one.component';

describe('LoyaltyOneComponent', () => {
  let component: LoyaltyOneComponent;
  let fixture: ComponentFixture<LoyaltyOneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoyaltyOneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoyaltyOneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
