import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StatisticsStudentDetailComponent } from './statistics-student-detail.component';

describe('StatisticsStudentDetailComponent', () => {
  let component: StatisticsStudentDetailComponent;
  let fixture: ComponentFixture<StatisticsStudentDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StatisticsStudentDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StatisticsStudentDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
