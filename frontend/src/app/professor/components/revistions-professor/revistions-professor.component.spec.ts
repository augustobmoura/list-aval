import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RevistionsProfessorComponent } from './revistions-professor.component';

describe('RevistionsProfessorComponent', () => {
  let component: RevistionsProfessorComponent;
  let fixture: ComponentFixture<RevistionsProfessorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RevistionsProfessorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RevistionsProfessorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
