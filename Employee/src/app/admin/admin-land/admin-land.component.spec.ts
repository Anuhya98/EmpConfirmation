import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminLandComponent } from './admin-land.component';

describe('AdminLandComponent', () => {
  let component: AdminLandComponent;
  let fixture: ComponentFixture<AdminLandComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminLandComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminLandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  
});
