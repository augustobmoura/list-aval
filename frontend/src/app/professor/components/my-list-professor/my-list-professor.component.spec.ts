import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyListProfessorComponent } from './my-list-professor.component';

describe('MyListProfessorComponent', () => {
  let component: MyListProfessorComponent;
  let fixture: ComponentFixture<MyListProfessorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyListProfessorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyListProfessorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
