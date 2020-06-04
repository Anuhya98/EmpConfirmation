import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserLandComponent } from './user-land.component';

describe('UserLandComponent', () => {
  let component: UserLandComponent;
  let fixture: ComponentFixture<UserLandComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserLandComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserLandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
