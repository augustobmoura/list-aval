import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyListDetailComponent } from './my-list-detail.component';

describe('MyListDetailComponent', () => {
  let component: MyListDetailComponent;
  let fixture: ComponentFixture<MyListDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyListDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyListDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
