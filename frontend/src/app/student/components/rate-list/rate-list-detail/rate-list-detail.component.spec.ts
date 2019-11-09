import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RateListDetailComponent } from './rate-list-detail.component';

describe('RateListDetailComponent', () => {
  let component: RateListDetailComponent;
  let fixture: ComponentFixture<RateListDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RateListDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RateListDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
