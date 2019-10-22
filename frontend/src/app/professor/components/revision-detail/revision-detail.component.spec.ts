import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RevisionDetailComponent } from './revision-detail.component';

describe('RevisionDetailComponent', () => {
  let component: RevisionDetailComponent;
  let fixture: ComponentFixture<RevisionDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RevisionDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RevisionDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
