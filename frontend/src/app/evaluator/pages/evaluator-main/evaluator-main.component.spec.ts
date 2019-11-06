import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EvaluatorMainComponent } from './evaluator-main.component';

describe('EvaluatorMainComponent', () => {
  let component: EvaluatorMainComponent;
  let fixture: ComponentFixture<EvaluatorMainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EvaluatorMainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EvaluatorMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
